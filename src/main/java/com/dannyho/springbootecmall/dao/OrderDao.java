package com.dannyho.springbootecmall.dao;

import com.dannyho.springbootecmall.dto.OrderQueryParams;
import com.dannyho.springbootecmall.model.Order;
import com.dannyho.springbootecmall.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Order getOrderById(Integer orderId);

    List<Order> getOrders(OrderQueryParams userId);

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<OrderItem> geOrderItemsByOrderId(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
