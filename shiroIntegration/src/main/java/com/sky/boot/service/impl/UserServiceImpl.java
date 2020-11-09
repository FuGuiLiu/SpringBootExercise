package com.sky.boot.service.impl;

import com.sky.boot.dao.UserDao;
import com.sky.boot.entity.User;
import com.sky.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author Administrator
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserByName(String name) {
        return userDao.queryUserByName(name);
    }
}
