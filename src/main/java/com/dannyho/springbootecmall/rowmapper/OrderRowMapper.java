package com.dannyho.springbootecmall.rowmapper;

import com.dannyho.springbootecmall.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        return Order.builder()
                .orderId(resultSet.getInt("order_id"))
                .userId(resultSet.getInt("user_id"))
                .totalAmount(resultSet.getInt("total_amount"))
                .createdDate(resultSet.getTimestamp("created_date"))
                .lastModifiedDate(resultSet.getTimestamp("last_modified_date"))
                .build();
    }
}
