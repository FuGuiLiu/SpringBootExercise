package com.sky.idea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 */
@Controller
public class RoutingController {
    @RequestMapping(value = {"/index", "/", "index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/toLogin", "/login.html"})
    public String toLogin() {
        return "/views/login";
    }

    @GetMapping("level1/{id}")
    public String level1(@PathVariable(value = "id") Integer id) {
        return "/views/level1/" + id;
    }

    @GetMapping("level2/{id}")
    public String level2(@PathVariable(value = "id") Integer id) {
        return "/views/level2/" + id;
    }

    @GetMapping("level3/{id}")
    public String level3(@PathVariable(value = "id") Integer id) {
        return "/views/level3/" + id;
    }
//
//    @GetMapping("/logout")
//    public String logOut() {
//        return "index";
//    }
}
