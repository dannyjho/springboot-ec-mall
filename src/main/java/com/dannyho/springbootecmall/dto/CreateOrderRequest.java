package com.dannyho.springbootecmall.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(force = true)
public class CreateOrderRequest {
    @NotEmpty
    List<BuyItem> buyItemList;

}
