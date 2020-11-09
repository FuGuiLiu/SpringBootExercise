package com.sky.boot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 */
@Controller
public class RouteController {
    @RequestMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("msg", "hello,Shiro");
        return "index";
    }

    @RequestMapping("user/add")
    public String add() {
        return "/user/add";
    }

    @RequestMapping("user/update")
    public String update() {
        return "/user/update";
    }

    @RequestMapping("toLogin")
    public String toLogin() {
        return "/user/login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(String username, String password, Model model) {
        // 获取当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        //设置令牌
        UsernamePasswordToken loginUserToken = new UsernamePasswordToken(username, password);

        try {
            //登录校验
            subject.login(loginUserToken);
            return "/index";
        } catch (UnknownAccountException uae) {  // 账户不存在
            model.addAttribute("error", "无效的用户名");
            return "/user/login";
        } catch (IncorrectCredentialsException ice) { //密码错误
            model.addAttribute("error", "无效的密码");
            return "/user/login";
        }
    }
}
