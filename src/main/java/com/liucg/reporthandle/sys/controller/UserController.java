package com.liucg.reporthandle.sys.controller;


import com.alibaba.fastjson.JSONObject;
import com.liucg.reporthandle.sys.entity.User;
import com.liucg.reporthandle.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;


@RestController
@RequestMapping("/sys")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 创建账号
     * @param user
     * @return
     */
   @PostMapping("/createUser")
    public String createUser(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
       boolean flag= userService.createUser(user);
       if(flag){
           jsonObject.put("result","添加成功");
       }else{
           jsonObject.put("result","添加失败");
       }
        return jsonObject.toString();
    }

    /**
     * 更新账号
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        boolean flag= userService.updateUser(user);
        if(flag){
            jsonObject.put("result","调整成功");
        }else{
            jsonObject.put("result","调整失败");
        }
        return jsonObject.toString();
    }
}
