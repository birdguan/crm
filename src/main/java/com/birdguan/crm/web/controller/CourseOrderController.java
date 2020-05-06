package com.birdguan.crm.web.controller;

import com.birdguan.crm.model.CURDResult;
import com.birdguan.crm.model.CourseOrder;
import com.birdguan.crm.model.PageResult;
import com.birdguan.crm.service.CourseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/courseorder")
public class CourseOrderController {
    @Autowired
    CourseOrderService orderService;

    /**
     * 课程详情列表
     * @return
     */
    @RequestMapping("/list")
    public String list() {
        return "/courseorder/list";
    }

    /**
     * 添加课程信息
     * @return
     */
    @RequestMapping("/add")
    public String add() {
        return "/courseorder/add";
    }

    /**
     * 课程详情页
     * @return
     */
    @RequestMapping("/detail")
    public String detail(Model model, String order_id) {
        CourseOrder order = orderService.findByOrderId(order_id);
        model.addAttribute("order", order);
        return "/courseorder/detail";
    }

    /**
     * 保存添加的课程信息
     * @param order
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public CURDResult save(CourseOrder order) {
        if (order.getOrder_id() == null || order.getOrder_id().length() == 0) {
            orderService.save(order);
        } else {
            orderService.update(order);
        }
        CURDResult result = new CURDResult();

        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public CURDResult delete(String order_id) {
        CURDResult result = new CURDResult();
        orderService.deleteByOrderId(order_id);
        return result;
    }

    @RequestMapping("/edit")
    public String edit(Model model, String order_id) {
        CourseOrder order = orderService.findByOrderId(order_id);
        model.addAttribute("order", order);
        return "/courseorder/edit";
    }

    @RequestMapping("/listjson")
    @ResponseBody
    public PageResult<CourseOrder> listJson(CourseOrder condition, int page, int limit) {
        PageResult<CourseOrder> result = orderService.findPageResult(condition, page, limit);
        return result;
    }
}
