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
     * 返回Map类型的List接口方法实现
     * @param user
     * @author lixu
     * @return List<Map>
     */
    @Override
    public List<Map> queryUserMapList(User user) {
        return mapper.queryUserMapList(user);
    }

    /**
     * 删除用户
     * @param user
     * @author lixu
     */
    @Override
    public void deleteUser(User user) {
        mapper.deleteUser(user);
    }

    /**
     * 新增或修改用户
     * @param user
     * @author lixu
     */
    @Override
    public void demoSaveOrUpdateUser(User user) {
        //当id为0时，代表未传入用户ID，则可判定为是新增用户可以保存
        if(0 == user.getId()){
            user.setUserPassword("123456");
            mapper.save(user);
        }else{
            mapper.update(user);
        }
    }
}
