package com.birdguan.crm.service;

import com.birdguan.crm.model.CourseOrder;
import com.birdguan.crm.model.PageResult;

public interface CourseOrderService {
    public PageResult<CourseOrder> findPageResult(CourseOrder condition, int page, int pageSize);
}
