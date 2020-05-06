package com.birdguan.crm.service;

import com.birdguan.crm.mapper.CourseOrderMapper;
import com.birdguan.crm.model.CourseOrder;
import com.birdguan.crm.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourserOrderServiceImpl implements CourseOrderService {
    @Autowired
    CourseOrderMapper orderMapper;

    @Override
    public PageResult<CourseOrder> findPageResult(CourseOrder condition, int page, int pageSize) {
        PageResult<CourseOrder> result = new PageResult<>();
        result.setCode(0);

        Map<String, Object> params = new HashMap<>();
        // 获取总记录数
        int count = orderMapper.findCountByMap(params);
        List<CourseOrder> list = orderMapper.findListByMap(params);
        result.setData(list);
        return result;
    }
}
