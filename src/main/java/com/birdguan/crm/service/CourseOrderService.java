package com.birdguan.crm.service;

import com.birdguan.crm.model.CourseOrder;
import com.birdguan.crm.model.PageResult;

public interface CourseOrderService {
    public PageResult<CourseOrder> findPageResult(CourseOrder condition, int page, int pageSize);

    public void save(CourseOrder order);

    public CourseOrder findByOrderId(String order_id);

    public void deleteByOrderId(String order_id);

    public void update(CourseOrder order);
}
