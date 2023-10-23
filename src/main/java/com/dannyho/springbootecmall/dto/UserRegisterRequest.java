package com.dannyho.springbootecmall.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterRequest {

    @NotBlank
    @Email
    String email;

    @NotBlank
    String password;
}
