package com.dannyho.springbootecmall.service.impl;

import com.dannyho.springbootecmall.dao.UserDao;
import com.dannyho.springbootecmall.dto.UserRegisterRequest;
import com.dannyho.springbootecmall.model.User;
import com.dannyho.springbootecmall.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
