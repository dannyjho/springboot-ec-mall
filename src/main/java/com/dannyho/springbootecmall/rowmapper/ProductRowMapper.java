package com.dannyho.springbootecmall.rowmapper;

import com.dannyho.springbootecmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        return Product.builder()
                .id(resultSet.getLong("product_id"))
                .productName(resultSet.getString("product_name"))
                .category(resultSet.getString("category"))
                .imageUrl(resultSet.getString("image_url"))
                .price(resultSet.getInt("price"))
                .stock(resultSet.getInt("stock"))
                .description(resultSet.getString("description"))
                .createDate(resultSet.getTimestamp("created_date"))
                .lastModifyTime(resultSet.getTimestamp("last_modified_date")).build();
    }
}
