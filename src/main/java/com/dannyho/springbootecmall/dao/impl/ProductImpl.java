package com.dannyho.springbootecmall.dao.impl;

import com.dannyho.springbootecmall.constant.ProductCategory;
import com.dannyho.springbootecmall.dao.ProductDao;
import com.dannyho.springbootecmall.dto.ProductRequest;
import com.dannyho.springbootecmall.model.Product;
import com.dannyho.springbootecmall.rowmapper.ProductRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class ProductImpl implements ProductDao {


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProductImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Product> getProducts(ProductCategory category, String search) {
        String sql = "SELECT product_id, product_name, category, image_url, " +
                "price,stock, description, created_date, last_modified_date FROM product WHERE 1=1";

        HashMap<String, Object> map = new HashMap<>();
        if (category != null) {
            sql = sql + " AND category = :category";
            map.put("category", category.name());
        }

        if (search != null) {
            sql = sql + " AND product_name LIKE :productName";
            map.put("productName", "%" + search + "%");
        }

        return namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
    }

    @Override
    public Product getProductById(long productId) {
        String sql = "SELECT product_id, product_name, category, image_url, price," +
                " stock, description, created_date, last_modified_date FROM product WHERE product_id = :productId";

        HashMap<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        List<Product> result = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        return !result.isEmpty() ? result.get(0) : null;
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO product (product_name, category," +
                " image_url, price, stock, description, created_date," +
                " last_modified_date) VALUES (:productName, :category," +
                " :imageUrl, :price, :stock, :description, :createDate, :lastModifyDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        LocalDateTime now = LocalDateTime.now();
        map.put("createDate", now);
        map.put("lastModifyDate", now);

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    @Override
    public void updateProduct(long productId, ProductRequest productRequest) {
        String sql = "UPDATE product SET product_name = :productName, category = :category," +
                " image_url = :imageUrl, price = :price," +
                " stock = :stock, description = :description," +
                " last_modified_date = :lastModifiedDate WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        map.put("lastModifiedDate", LocalDateTime.now());

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map));
    }

    @Override
    public void deleteProductById(long productId) {
        String sql = "DELETE FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map));
    }
}
