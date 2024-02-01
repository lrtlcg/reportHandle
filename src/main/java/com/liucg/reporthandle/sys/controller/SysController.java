package com.liucg.reporthandle.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.liucg.reporthandle.sys.entity.User;
import com.liucg.reporthandle.sys.service.UserService;
import com.liucg.reporthandle.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统类方法
 */
@RestController
public class SysController {
    @Resource
    TokenUtil tokenUtil;
    @Autowired
    UserService userService;

    /**
     * 获取token
     *
     * @param user 用户账号
     * @return 返回token
     */
    @RequestMapping(value = "/login")
    public String getToken(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user1 = userService.isExist(user);// 获取用户信息
        if (user1!=null) {
            if(encoder.matches(user.getuPwd(),user1.getuPwd())){ // 密码是否匹配
                String token = tokenUtil.buildToken(user);
                jsonObject.put("token", token);
            }else{
                jsonObject.put("token", "密码不正确");
            }
        } else {
            jsonObject.put("error", "用户名不正确");
        }
        return jsonObject.toString();
    }
}
