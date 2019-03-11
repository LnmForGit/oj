package com.oj.controller;
import com.oj.entity.User;
import com.oj.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixu
 * @Time 2019年3月9日 15点21分
 * @Description Demo类
 */

//向框架中注册Controlle
@Controller
public class DemoController {
    //依赖注入UserService
    @Autowired
    private UserService userService;

    //将请求接口对应为"/demo"
    @RequestMapping("/demo")
    //返回demo.html页面
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("msg", "hello world");
        return "demo";
    }


    //将请求接口对应为"/demo/SlectMapList"
    @PostMapping("/demo/SlectMapList")
    @ResponseBody
    //返回Map类型的JsonList
    public List<Map> demoSlectMapList(@RequestBody User user) {
        List<Map> list = userService.queryUserMapList(user);
        return list;
    }

    //将请求接口对应为"/demo/UserDelete"
    @PostMapping("/demo/UserDelete")
    @ResponseBody
    //通过ID删除用户
    public Map<String, String> demoUserDelete(@RequestBody User user) {
        List<Map> list = userService.queryUserMapList(user);
        Map<String, String> map = new HashMap<>();
        map.put("flag","1");
        userService.deleteUser(user);
        return map;
    }

    //将请求接口对应为"/demo/GetUserById"
    @PostMapping("/demo/GetUserById")
    @ResponseBody
    //通过ID查找用户
    public Map demoGetUserById(@RequestBody User user) {
        return userService.queryUserMapList(user).get(0);
    }

    //将请求接口对应为"/demo/SaveOrUpdateUser"
    @PostMapping("/demo/SaveOrUpdateUser")
    @ResponseBody
    //添加或更新用户
    public Map<String, String> demoSaveOrUpdateUser(@RequestBody User user) {
        Map<String, String> map = new HashMap<>();
        map.put("flag","1");
        userService.demoSaveOrUpdateUser(user);
        return map;
    }

}
