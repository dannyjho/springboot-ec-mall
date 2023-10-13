package com.dannyho.springbootecmall.dto;

import com.dannyho.springbootecmall.constant.ProductCategory;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductRequest {
    @NotNull
    String productName;

    @NotNull
    ProductCategory category;

    @NotNull
    String imageUrl;

    @NotNull
    Integer price;

    @NotNull
    Integer stock;

    String description;
}
