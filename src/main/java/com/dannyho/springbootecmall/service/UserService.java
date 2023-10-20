package com.dannyho.springbootecmall.service;

import com.dannyho.springbootecmall.dto.UserLoginRequest;
import com.dannyho.springbootecmall.dto.UserRegisterRequest;
import com.dannyho.springbootecmall.model.User;

public interface UserService {
    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
