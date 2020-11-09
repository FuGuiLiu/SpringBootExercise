package com.sky.boot;

import com.sky.boot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerServerApplicationTests {
    @Autowired
    @Qualifier(value = "userService")
    UserService userService;

    @Test
    void contextLoads() {
        userService.getAndUseTheTicket();
    }

}
