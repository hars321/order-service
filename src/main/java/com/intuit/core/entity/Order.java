package com.intuit.core.entity;

import com.intuit.core.enums.OrderStatus;
import com.intuit.util.TimeUtils;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bidding_id", nullable = false)
    private Long biddingId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "auction_id", nullable = false, unique = true)
    private Long auctionId;

    @Column(name = "bid_price", nullable = false)
    private Double bidPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status = OrderStatus.CREATED;

    @Column(name = "created_at")
    private Long createdAt = TimeUtils.getCurrentTimeStamp();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBiddingId() {
        return biddingId;
    }

    public void setBiddingId(Long biddingId) {
        this.biddingId = biddingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
