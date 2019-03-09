package com.oj.service;

import com.oj.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author lixu
 * @Time 2019年3月9日 15点21分
 * @Description 创建Service接口，统一方法类型和方法名
 */
public interface UserService {
    //返回User类型的List
    public List<User> queryUserList();

    //通过User对象进行数据保存，并返回插入数据库的自增主键
    public int save(User user);

    //返回Map类型的List
    public List<Map> queryUserMapList();
}
