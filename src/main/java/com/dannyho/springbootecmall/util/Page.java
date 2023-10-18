package com.dannyho.springbootecmall.util;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Page<T> {

    Integer limit;
    Integer offset;
    Integer total;
    List<T> results;
}
