package com.birdguan.crm.mapper;

import com.birdguan.crm.model.CourseOrder;

import java.util.List;
import java.util.Map;


public interface CourseOrderMapper {
    public int findCountByMap(Map<String, Object> map);
    public List<CourseOrder> findListByMap(Map<String, Object> map);
}
