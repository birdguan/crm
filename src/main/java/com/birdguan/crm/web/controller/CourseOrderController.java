package com.birdguan.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courseorder")
public class CourseOrderController {

    @RequestMapping("/list")
    public String list() {
        return "courseorder/list";
    }
}
