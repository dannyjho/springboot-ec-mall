package com.dannyho.springbootecmall.dao;

import com.dannyho.springbootecmall.model.Product;

public interface ProductDao {
    Product getProductById(long productId);
}
