package com.dannyho.springbootecmall.model;

import lombok.Value;

@Value
public class OrderItem {
    Integer orderItemId;
    Integer orderId;
    Integer productId;
    Integer quantity;
    Integer amount;
}
