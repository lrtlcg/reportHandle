package com.liucg.reporthandle.controller;

import com.liucg.reporthandle.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/redisTest")
public class RedisTest {
    //  1.注入StringRedisTemplate
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/t1")
    public String t1(){
        // 2.new一个工具类对象
        RedisUtils redisUtils = new RedisUtils(stringRedisTemplate);

        // 3.开心的调用工具类任意方法
//        Map<String, String> map = redisUtils.hashMapGet(redisKey);
        redisUtils.remove("token");
//        redisUtils.add("token","sssss");
//        redisUtils.get("token")
        redisUtils.set("02691","ashkhksdhfkayfihdsakfakj",100000L);
        return "成功";
    }
    @RequestMapping("/t2")
    public String t2(){
        // 2.new一个工具类对象
        RedisUtils redisUtils = new RedisUtils(stringRedisTemplate);
        return redisUtils.get("02691");
    }
}
