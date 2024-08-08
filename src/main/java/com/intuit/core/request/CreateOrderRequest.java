package com.intuit.core.request;



import lombok.Data;

import java.io.Serializable;

@Data
public class CreateOrderRequest implements Serializable {

    private Long biddingId;
    private Long userId;
    private Long auctionId;
    private Double bidPrice;

    // Getters and Setters

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
}
