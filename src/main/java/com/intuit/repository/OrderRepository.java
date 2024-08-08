package com.intuit.repository;


import com.intuit.core.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Custom query to check if an order exists by auctionId
    boolean existsByAuctionId(Long auctionId);

    // Optional: Add custom query methods as needed
    Optional<Order> findByAuctionId(Long auctionId);
}
