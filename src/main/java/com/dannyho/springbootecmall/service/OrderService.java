package com.dannyho.springbootecmall.service;

import com.dannyho.springbootecmall.dto.CreateOrderRequest;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
