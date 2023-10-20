package com.dannyho.springbootecmall.dto;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Value
public class UserRegisterRequest {

    @NotBlank
    @Email
    String email;

    @NotBlank
    String password;
}
