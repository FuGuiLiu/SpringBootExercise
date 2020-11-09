package com.sky.idea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "username") String userName, @RequestParam(value = "password") String password, Model model, HttpSession session) {
        if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)) {
            if ("sky".equals(userName) && "123".equals(password)) {
                session.setAttribute("userName", userName);
                return "redirect:/main.html";
            } else {
                model.addAttribute("msg", "账户或密码错误");
                return "/index";
            }
        }
        model.addAttribute("msg", "账户或密码错误");
        return "/index";
    }
}
