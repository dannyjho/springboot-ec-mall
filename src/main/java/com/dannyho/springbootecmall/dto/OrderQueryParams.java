package com.dannyho.springbootecmall.dto;

import lombok.Value;


@Value
public class OrderQueryParams {
    Integer userId;
    Integer limit;
    Integer offset;
}
