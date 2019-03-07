package com.oj.service.serviceImpl;

import com.oj.entity.User;
import com.oj.mapper.UserMapper;
import com.oj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper mapper;

    @Override
    public List<User> queryUserList() {
        return mapper.queryUserList();
    }

    @Override
    public int save(User user) {
        return mapper.save(user);
    }
}
