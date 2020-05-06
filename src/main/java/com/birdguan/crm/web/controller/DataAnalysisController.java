package com.birdguan.crm.web.controller;

import com.birdguan.crm.model.MonthIncome;
import com.birdguan.crm.service.CourseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dataanalysis")
public class DataAnalysisController {

    @Autowired
    CourseOrderService orderService;

    @RequestMapping("/income")
    public String income() {
        return "/dataanalysis/income";
    }

    @RequestMapping("/monthincomes")
    @ResponseBody
    public List<MonthIncome> getMonthIncomes() {
        List<MonthIncome> list = orderService.getMonthIncomes();
        return list;
    }

}
