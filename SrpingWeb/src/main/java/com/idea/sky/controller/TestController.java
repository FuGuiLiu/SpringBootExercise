package com.idea.sky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * @author Administrator
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "你好,springBoot");
        modelAndView.setViewName("test");
        modelAndView.addObject("users", Arrays.asList("富贵", "sky"));
        return modelAndView;
    }
}
