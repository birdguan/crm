package com.birdguan.crm.mapper;

import com.birdguan.crm.model.CourseCategory;

import java.util.List;

public interface CourseCategoryMapper {
    /**
     *
     * @return 所有课程列表信息
     */
    public List<CourseCategory> findAllList();

}
