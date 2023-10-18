package com.dannyho.springbootecmall.dto;

import com.dannyho.springbootecmall.constant.ProductCategory;
import lombok.Value;

@Value
public class ProductQueryParams {

    ProductCategory productCategory;
    String search;
}
