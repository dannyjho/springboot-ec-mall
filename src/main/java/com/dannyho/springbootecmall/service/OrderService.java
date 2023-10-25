package com.dannyho.springbootecmall.service;

import com.dannyho.springbootecmall.dto.CreateOrderRequest;
import com.dannyho.springbootecmall.dto.OrderQueryParams;
import com.dannyho.springbootecmall.model.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
