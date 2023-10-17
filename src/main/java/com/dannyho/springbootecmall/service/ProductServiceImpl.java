package com.dannyho.springbootecmall.service;

import com.dannyho.springbootecmall.constant.ProductCategory;
import com.dannyho.springbootecmall.dao.ProductDao;
import com.dannyho.springbootecmall.dto.ProductRequest;
import com.dannyho.springbootecmall.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getProducts(ProductCategory category, String search) {
        return productDao.getProducts(category, search);
    }


    public Product getProductById(long productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(long productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProductById(long productId) {
        productDao.deleteProductById(productId);
    }
}
