package com.sky.boot.controller;

import com.sky.boot.entity.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    @ApiOperation(value = "Swaggerrrrrr")
    public String hello() {
        return "hello,swagger";
    }

    @GetMapping("/user")
    @ApiOperation(value = "获取用户信息")
    public User getUser(@ApiParam(value = "传入用户对象") User user) {
        return user;
    }
}
