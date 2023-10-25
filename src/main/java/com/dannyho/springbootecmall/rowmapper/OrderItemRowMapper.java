package com.dannyho.springbootecmall.rowmapper;

import com.dannyho.springbootecmall.model.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemRowMapper implements RowMapper<OrderItem> {
    @Override
    public OrderItem mapRow(ResultSet resultSet, int i) throws SQLException {
        return OrderItem.builder()
                .orderItemId(resultSet.getInt("order_item_id"))
                .orderId(resultSet.getInt("order_id"))
                .productId(resultSet.getInt("product_id"))
                .quantity(resultSet.getInt("quantity"))
                .amount(resultSet.getInt("amount"))
                .productName(resultSet.getString("product_name"))
                .imageUrl(resultSet.getString("image_url"))
                .build();
    }
}
