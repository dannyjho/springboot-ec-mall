package com.dannyho.springbootecmall.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.sql.Timestamp;
import java.util.List;

@Builder
@Data
public class Order {
    Integer orderId;
    Integer userId;
    Integer totalAmount;
    Timestamp createdDate;
    Timestamp lastModifiedDate;
    List<OrderItem> orderItemList;
}
