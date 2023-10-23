package com.dannyho.springbootecmall.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
@Value
public class UserLoginRequest {

    @NotBlank
    @Email
    String email;

    @NotBlank
    String password;
}
