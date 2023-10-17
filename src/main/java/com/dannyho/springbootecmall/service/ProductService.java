package com.dannyho.springbootecmall.service;

import com.dannyho.springbootecmall.constant.ProductCategory;
import com.dannyho.springbootecmall.dto.ProductRequest;
import com.dannyho.springbootecmall.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(long id);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(long productId, ProductRequest productRequest);

    void deleteProductById(long productId);
}
