package com.oj.service.serviceImpl;

import com.oj.entity.User;
import com.oj.mapper.UserMapper;
import com.oj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * @author lixu
 * @Time 2019年3月9日 15点21分
 * @Description 创建Service接口实现，进行Mapper接口调用和数据预处理操作
 */

//向框架中注册Service
@Service

public class UserServiceImpl implements UserService {
    //注入UserMapper
    @Autowired(required = false)
    private UserMapper mapper;

    /**
     * 返回User类型的List接口方法实现
     * @author lixu
     * @return List<User>
     */
    @Override
    public List<User> queryUserList() {
        return mapper.queryUserList();
    }

    /**
     * 通过User对象进行数据保存，并返回插入数据库的自增主键接口方法实现
     * @author lixu
     * @param user
     * @return int
     */
    @Override
    public int save(User user) {
        mapper.save(user);
        return user.getId();
    }

    /**
     * 返回Map类型的List接口方法实现
     * @author lixu
     * @return List<Map>
     */
    @Override
    public List<Map> queryUserMapList() {
        return mapper.queryUserMapList();
    }
}
