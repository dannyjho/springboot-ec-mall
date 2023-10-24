package com.dannyho.springbootecmall.dao;

import com.dannyho.springbootecmall.dto.CreateOrderRequest;
import com.dannyho.springbootecmall.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
