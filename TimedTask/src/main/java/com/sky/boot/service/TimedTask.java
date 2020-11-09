package com.sky.boot.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * @author Administrator
 */
@Service
public class TimedTask {
    @Resource
    JavaMailSender javaMailSender;

    public static class Initial {


        public static Calendar getCalendar() {
            System.out.println("初始化一次");
            return Calendar.getInstance();
        }
    }


    @Scheduled(cron = "0/5 * 13 14 10 ?")
    public void hello() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("崩坏官方客服");
        message.setText("你好,由于您违反了,我们未充钱策略,现在您此游戏所有的公司下的所有游戏将被禁用,请于2020/10/15 之前前往官网进行解封确认");
        message.setTo("3441633296@qq.com");
        message.setFrom("2677672@gmail.com");

        javaMailSender.send(message);
        // Calendar calendar = Initial.getCalendar();
        // int year = calendar.get(Calendar.YEAR);
        // int month = calendar.get(Calendar.MONTH);
        // int day = calendar.get(Calendar.DAY_OF_MONTH);
        // int hour = calendar.get(Calendar.HOUR);
        // int minute = calendar.get(Calendar.MINUTE);
        // int second = calendar.get(Calendar.SECOND);
        // System.out.println("hello,你被执行了" + "执行时间:" + year + "/" + ++month + "/" + day + "\t" + hour + ":" + minute + ":" + second);
    }
}
