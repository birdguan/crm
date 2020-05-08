package com.birdguan.crm.service;

import com.birdguan.crm.model.User;

public interface UserService {
    public User findByUsername(String username);
}
