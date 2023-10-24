package com.dannyho.springbootecmall.model;

import lombok.Value;

import java.sql.Timestamp;

@Value
public class Order {

    Integer orderId;
    Integer userId;
    Integer totalAmount;
    Timestamp createdDate;
    Timestamp lastModifiedDate;
}
