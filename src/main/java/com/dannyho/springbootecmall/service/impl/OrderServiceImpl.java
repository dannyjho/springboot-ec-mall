package com.dannyho.springbootecmall.service.impl;

import com.dannyho.springbootecmall.dao.OrderDao;
import com.dannyho.springbootecmall.dao.ProductDao;
import com.dannyho.springbootecmall.dto.BuyItem;
import com.dannyho.springbootecmall.dto.CreateOrderRequest;
import com.dannyho.springbootecmall.model.OrderItem;
import com.dannyho.springbootecmall.model.Product;
import com.dannyho.springbootecmall.service.OrderService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final ProductDao productDao;

    public OrderServiceImpl(OrderDao orderDao, ProductDao productDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            // 計算總價
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            // 轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem(null, null, buyItem.getProductId(), buyItem.getQuantity(), amount);
            orderItemList.add(orderItem);
        }

        Integer orderId = orderDao.createOrder(userId, totalAmount);
        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }
}