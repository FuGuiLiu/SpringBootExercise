package com.sky.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  //开启调度器

public class TimedtaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimedtaskApplication.class, args);
    }

}
