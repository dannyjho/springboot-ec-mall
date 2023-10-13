package com.dannyho.springbootecmall.dao;

import com.dannyho.springbootecmall.dto.ProductRequest;
import com.dannyho.springbootecmall.model.Product;

public interface ProductDao {
    Product getProductById(long productId);

    Integer createProduct(ProductRequest productRequest);

}
