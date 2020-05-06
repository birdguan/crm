package com.birdguan.crm.web.controller;

import com.birdguan.crm.model.CourseOrder;
import com.birdguan.crm.model.PageResult;
import com.birdguan.crm.service.CourseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/courseorder")
public class CourseOrderController {
    @Autowired
    CourseOrderService orderService;

    @RequestMapping("/list")
    public String list() {
        return "courseorder/list";
    }

    @RequestMapping("/listjson")
    @ResponseBody
    public PageResult<CourseOrder> listJson() {
        PageResult<CourseOrder> result = orderService.findPageResult(null, 1, 8);
        return result;
    }
}
