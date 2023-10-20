package com.dannyho.springbootecmall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;

@Builder
@Value
public class User {
    Integer userId;
    String email;
    @JsonIgnore
    String password;
    Timestamp createdDate;
    Timestamp lastModifiedDate;
}
