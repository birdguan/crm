package com.birdguan.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/login-error")
    public String loginError() {
        return "/login-error";
    }
}
