package com.sky.boot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping("/unAuthorized")
    public String unAuthorized() {
        return "未经授权不得访问";
    }

    @RequestMapping(value = "/logout")
    public String logOut() {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/index";
    }
}

