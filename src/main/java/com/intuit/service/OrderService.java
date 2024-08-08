package com.intuit.service;

import com.intuit.core.entity.Order;
import com.intuit.core.enums.OrderStatus;
import com.intuit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Long biddingId, Long userId, Long auctionId, Double bidPrice) {
        if (orderRepository.existsByAuctionId(auctionId)) {
            throw new IllegalStateException("An order already exists for this auction.");
        }
        Order order = new Order();
        order.setBiddingId(biddingId);
        order.setUserId(userId);
        order.setAuctionId(auctionId);
        order.setBidPrice(bidPrice);
        orderRepository.save(order);

        return order;
    }

    public void completeOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        if (order.getStatus() != OrderStatus.PAID) {
            throw new IllegalStateException("Order must be paid before completing.");
        }

        order.setStatus(OrderStatus.COMPLETED);
        orderRepository.save(order);
    }

    public void markOrderAsPaid(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        order.setStatus(OrderStatus.PAID);
        orderRepository.save(order);
    }

    public Order search(Long orderId){
        return orderRepository.findById(orderId).get();
    }
}
