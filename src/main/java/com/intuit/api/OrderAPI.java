package com.intuit.api;


import com.intuit.core.entity.ApiResponse;
import com.intuit.core.entity.Order;
import com.intuit.core.request.CreateOrderRequest;
import com.intuit.service.OrderService;
import com.intuit.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderAPI {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Order>> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        try {
            return ResponseUtil.successResponse(orderService.createOrder(
                    createOrderRequest.getBiddingId(),
                    createOrderRequest.getUserId(),
                    createOrderRequest.getAuctionId(),
                    createOrderRequest.getBidPrice()
            ));
        }
        catch (Exception e){
            return ResponseUtil.errorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{orderId}/complete")
    public ResponseEntity<ApiResponse<String>> completeOrder(@PathVariable Long orderId) {
        try {
            orderService.completeOrder(orderId);
            return ResponseUtil.successResponse("Success");
        }
        catch (Exception e){
            return ResponseUtil.errorResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{orderId}/mark-as-paid")
    public ResponseEntity<ApiResponse<String>> markOrderAsPaid(@PathVariable Long orderId) {
        try {
            orderService.markOrderAsPaid(orderId);
            return ResponseUtil.successResponse("Success");
        }
        catch (Exception e){
            return ResponseUtil.errorResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{orderId}/search")
    public ResponseEntity<ApiResponse<Object>> search(@PathVariable Long orderId) {
        try {
            return ResponseUtil.successResponse(orderService.search(orderId),"Success");
        }
        catch (Exception e){
            return ResponseUtil.errorResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
