package com.dannyho.springbootecmall.service;

import com.dannyho.springbootecmall.dto.CreateOrderRequest;
import com.dannyho.springbootecmall.model.Order;

public interface OrderService {
    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
