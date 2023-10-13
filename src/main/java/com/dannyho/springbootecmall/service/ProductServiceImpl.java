package com.dannyho.springbootecmall.service;

import com.dannyho.springbootecmall.dao.ProductDao;
import com.dannyho.springbootecmall.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService{

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }


    public Product getProductById(long productId) {
        return productDao.getProductById(productId);
    }
}
