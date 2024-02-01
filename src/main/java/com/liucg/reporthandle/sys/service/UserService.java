package com.liucg.reporthandle.sys.service;

import com.liucg.reporthandle.sys.dao.UserDao;
import com.liucg.reporthandle.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    public User isExist(User user) {
        return userDao.getUserByValidUser(user);
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    public Boolean createUser(User user) {
        List<Map<String, Object>> result = userDao.getUserByUser(user);
        Boolean flag = false;
        if (result.size() == 0) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String pwd = encoder.encode(user.getuPwd());
            user.setuPwd(pwd);
            UUID uuid = UUID.randomUUID();
            user.setId(uuid.toString());
//            user.setuOrg("用友");
            user.setuStatus("1");
            userDao.addUser(user);
            flag = true;
        }

        return flag;
    }

    /**
     * 更新账号
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        List<Map<String, Object>> result = userDao.getUserByUser(user);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode(user.getuPwd());
        user.setuPwd(pwd);
        boolean flag = false;
        if (result.size() > 0) { //判断账号是否存在
            Map<String, Object> map=result.get(0);
//            map.forEach((key,User)->{
//                System.out.println(key+"======123456======="+user.getuName());
//            });
            user.setId(map.get("ID").toString());// 历史数据主键
            if (userDao.updateUser(user) > 0) {
                flag = true;
            }
        }
        return flag;
    }

}
