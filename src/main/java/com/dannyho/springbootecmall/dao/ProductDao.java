package com.dannyho.springbootecmall.dao;

import com.dannyho.springbootecmall.dto.ProductRequest;
import com.dannyho.springbootecmall.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts();

    Product getProductById(long productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(long productId, ProductRequest productRequest);

    void deleteProductById(long productId);
}
