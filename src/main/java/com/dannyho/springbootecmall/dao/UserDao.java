package com.dannyho.springbootecmall.dao;

import com.dannyho.springbootecmall.dto.UserRegisterRequest;
import com.dannyho.springbootecmall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
