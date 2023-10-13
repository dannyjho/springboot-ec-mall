package com.dannyho.springbootecmall.model;

import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;

@Builder
@Value
public class Product {
    long id;
    String productName;
    String category;
    String imageUrl;
    Integer price;
    Integer stock;
    String description;
    Timestamp createDate;
    Timestamp lastModifyTime;
}
