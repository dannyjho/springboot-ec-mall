package com.dannyho.springbootecmall.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Value
@NoArgsConstructor(force = true)
public class CreateOrderRequest {
    @NotEmpty
    List<BuyItem> buyItemList;
}
