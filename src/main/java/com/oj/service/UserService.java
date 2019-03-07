package com.oj.service;

import com.oj.entity.User;

import java.util.List;

public interface UserService {
    public List<User> queryUserList();
    public int save(User user);
}
