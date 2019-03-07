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
 *
 */
@RestController
public class DemoController {
    @Autowired
    private UserService userService;
    @RequestMapping("/demo")
    @ResponseBody
    public List<User> index() {
        List<User> list = userService.queryUserList();
        return list;
    }
    @RequestMapping("/demoSave")
    @ResponseBody
    public String demoSave() {
        User user = new User();
        user.setUserName("Lee");
        user.setUserPassword("123456");
        user.setSex(0);
        int id = userService.save(user);
        return "用户信息保存成功，id为：" + id;
    }
}
