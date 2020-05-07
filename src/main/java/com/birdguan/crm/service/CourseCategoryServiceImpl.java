package com.birdguan.crm.service;

import com.birdguan.crm.mapper.CourseCategoryMapper;
import com.birdguan.crm.model.CourseCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {

    @Autowired
    CourseCategoryMapper categoryMapper;

    @Override
    public List<CourseCategory> findAllList() {
        return categoryMapper.findAllList();
    }
}
