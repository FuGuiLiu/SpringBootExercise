package com.sky.boot.service;

import com.sky.boot.entity.User;

/**
 * @author Administrator
 */
public interface UserService {
    /**
     * 查询用户有信息根据用户名称
     *
     * @param name
     * @return
     */
    User queryUserByName(String name);
}
