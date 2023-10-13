package com.dannyho.springbootecmall.dao.impl;

import com.dannyho.springbootecmall.dao.ProductDao;
import com.dannyho.springbootecmall.model.Product;
import com.dannyho.springbootecmall.rowmapper.ProductRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class ProductImpl implements ProductDao {


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProductImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Product getProductById(long productId) {
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, created_date, last_modified_date FROM product WHERE product_id = :productId";

        HashMap<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        List<Product> result = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());




        return !result.isEmpty() ? result.get(0) : null;
    }
}
