package com.dannyho.springbootecmall.model;

import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;

@Builder
@Value
public class User {
    Integer userId;
    String email;
    String password;
    Timestamp createdDate;
    Timestamp lastModifiedDate;
}
