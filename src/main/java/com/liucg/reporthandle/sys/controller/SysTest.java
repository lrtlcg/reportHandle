package com.liucg.reporthandle.sys.controller;

import com.liucg.reporthandle.sys.entity.User;
import com.liucg.reporthandle.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SysTest {
    @Autowired
    UserService userService;
    @RequestMapping("/t1")
    public String t1(@RequestBody User user){
        User user1=userService.isExist(user);
        if(user1!=null){
            return user1.getuName();
        }else {
            return "用户名或者账号不正确";
        }

    }
}
