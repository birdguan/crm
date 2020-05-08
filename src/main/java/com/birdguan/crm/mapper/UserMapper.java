package com.birdguan.crm.mapper;

import com.birdguan.crm.model.User;

public interface UserMapper {
    public User findByUsername(String username);
}
