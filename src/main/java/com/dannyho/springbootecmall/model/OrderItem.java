package com.dannyho.springbootecmall.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class OrderItem {
    Integer orderItemId;
    Integer orderId;
    Integer productId;
    Integer quantity;
    Integer amount;
    String productName;
    String imageUrl;
}
