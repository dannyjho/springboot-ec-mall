package com.dannyho.springbootecmall.model;

import com.dannyho.springbootecmall.constant.ProductCategory;
import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;

@Builder
@Value
public class Product {
    long id;
    String productName;
    ProductCategory category;
    String imageUrl;
    Integer price;
    Integer stock;
    String description;
    Timestamp createdDate;
    Timestamp lastModifiedDate;
}
