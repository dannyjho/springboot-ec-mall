package com.dannyho.springbootecmall.service;

import com.dannyho.springbootecmall.dto.UserRegisterRequest;
import com.dannyho.springbootecmall.model.User;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
