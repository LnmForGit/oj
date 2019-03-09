package com.oj.controller;
import com.oj.entity.User;
import com.oj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixu
 * @Time 2019年3月9日 15点21分
 * @Description Demo类
 */
@RestController
public class DemoController {
    //依赖注入UserService
    @Autowired
    private UserService userService;

    //将请求接口对应为"/demo"
    @RequestMapping("/demo")
    @ResponseBody
    //返回User类型的JsonList
    public List<User> index() {
        List<User> list = userService.queryUserList();
        return list;
    }

    //将请求接口对应为"/demoSave"
    @RequestMapping("/demoSave")
    @ResponseBody
    //通过User对象进行数据保存，并返回插入数据库的自增主键
    public String demoSave() {
        User user = new User();
        user.setUserName("Lee");
        user.setUserPassword("123456");
        user.setSex(0);
        return Integer.valueOf(userService.save(user)).toString();
    }

    //将请求接口对应为"/demoSlectMapList"
    @RequestMapping("/demoSlectMapList")
    @ResponseBody
    //返回Map类型的JsonList
    public List<Map> demoSlectMapList() {
        List<Map> list = userService.queryUserMapList();
        return list;
    }
}
