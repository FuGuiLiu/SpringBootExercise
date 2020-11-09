package com.sky.boot.dao;

import com.sky.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
@Mapper
public interface UserDao {
    /**
     * 查询用户信息根据用户名
     *
     * @param name
     * @return
     */
    User queryUserByName(@Param(value = "paramName") String name);
}
