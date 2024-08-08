package com.intuit.client;

import com.intuit.core.entity.Order;
import com.intuit.core.request.CreateOrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "order-client", url = "${order.api.url}")
public interface OrderClient {

    @PostMapping("/api/v1/orders/create")
    Order createOrder(@RequestBody CreateOrderRequest createOrderRequest);

    @PostMapping("/api/v1/orders/{orderId}/complete")
    void completeOrder(@PathVariable("orderId") Long orderId);

    @PostMapping("/api/v1/orders/{orderId}/mark-as-paid")
    void markOrderAsPaid(@PathVariable("orderId") Long orderId);
}
