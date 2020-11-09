package com.sky.boot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.annotation.Resource;
import java.util.Calendar;

@SpringBootTest
class TimedtaskApplicationTests {
    @Resource
    JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("崩坏官方客服");
        message.setText("你好,由于您违反了,我们未充钱策略,现在您此游戏所有的公司下的所有游戏将被禁用,请于2020/10/15 之前前往官网进行解封确认");
        message.setTo("3441633296@qq.com");

        javaMailSender.send(message);

        // Calendar calendar = Calendar.getInstance();
        // int year = calendar.get(Calendar.YEAR);
        // int month = calendar.get(Calendar.MONTH);
        // int day = calendar.get(Calendar.DAY_OF_MONTH);
        // int hour = calendar.get(Calendar.HOUR);
        // int minute = calendar.get(Calendar.MINUTE);
        // int second = calendar.get(Calendar.SECOND);
        // System.out.println("hello,你被执行了" + "执行时间:" + year + "/" + ++month + "/" + day + "\t" + hour + ":" + minute + ":" + second);

    }

}
