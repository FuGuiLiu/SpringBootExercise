package com.sky.boot.controller;

import com.sky.boot.service.AsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
public class HelloController {
    @Resource
    AsyncService asyncService;

    @GetMapping(value = "/hello")
    public String hello() {
        asyncService.hello();
        return "incoming";
    }
}
