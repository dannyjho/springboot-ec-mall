package com.dannyho.springbootecmall.dto;


import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class BuyItem {
    @NotNull
    Integer productId;

    @NotNull
    Integer quantity;
}
