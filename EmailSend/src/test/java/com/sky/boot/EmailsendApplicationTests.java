package com.sky.boot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

@SpringBootTest
class EmailsendApplicationTests {
    @Resource
    private JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {
    }

    @Test
    public void sendingSimpleMail() {
        // 发送一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        // 设定主题
        message.setSubject("test");
        // 设置内容
        message.setText("你好,富贵");
        // 设置发送给谁
        message.setTo("997121416@qq.com");
        // 设置发件者
        message.setFrom("liu997121@gmail.com");
        // 发送邮件
        javaMailSender.send(message);
    }

    @Test
    public void sendingComplicatedMail() throws Exception {
        // 发送一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // 组装,初始化复杂邮件帮助器
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        // 设定主题
        messageHelper.setSubject("test  plus");
        // 设置内容 如果为true 则可以解析 html标签
        messageHelper.setText("<p style='color:#007bff;'> 你好,富贵 plus </p>", true);

        // 添加附件
        messageHelper.addAttachment("this is a image and name is ", new File("C:\\Users\\Administrator\\OneDrive - 徐州开放大学\\Pictures\\木兰\\Snipaste_2020-09-20_22-09-55.png"));

        // 设置发送给谁
        messageHelper.setTo("997121416@qq.com");
        // 设置发件者
        messageHelper.setFrom("liu997121@gmail.com");

        javaMailSender.send(mimeMessage);
    }
}
