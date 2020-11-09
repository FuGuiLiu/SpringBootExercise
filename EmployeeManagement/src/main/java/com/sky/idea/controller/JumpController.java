package com.sky.idea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 */
//用来做跳转的controller
@Controller
public class JumpController {
    @RequestMapping("/dashboard")
    public String dashboard() {
        return "redirect:/main.html";
    }
}
