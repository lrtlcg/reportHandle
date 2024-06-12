package com.liucg.reporthandle.sys.dao;

import com.liucg.reporthandle.sys.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class UserDao {
    @Autowired
    @Qualifier("jdbcTemplateOne")
    JdbcTemplate jdbcTemplate;

    /**
     * 查询所有账号
     *
     * @return
     */
    public List<Map<String, Object>> getUserList() {
        String sql = "select * from Report_User";
        List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql);
        return userList;
    }

    /**
     * 获取用户
     *
     * @param ur 用户
     * @return
     */
    public User getUserByValidUser(User ur) {
        String sql = "select * from Report_User where USTATUS='1' AND UNAME='" + ur.getuName() + "'";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class));
        }catch ( EmptyResultDataAccessException e){
            log.error("不存在用户"+e);
            return user;
        }

        return user;
    }
    public List<Map<String, Object>>  getUserByUser(User ur) {
        String sql = "select * from Report_User where UNAME='" + ur.getuName() + "'";
        List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql);
        return userList;
    }


    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public int addUser(User user) {
        String sql = "insert into Report_User(ID, UNAME, UPWD, UORG,USTATUS) values(?,?,?,?,?)";

        Object[] objects = new Object[5];
        objects[0] = user.getId();
        objects[1] = user.getuName();
        objects[2] = user.getuPwd();
        objects[3] = user.getuOrg();
        objects[4] = user.getuStatus();
        return jdbcTemplate.update(sql, objects);
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    public int updateUser(User user) {
        String sql = "update Report_User set  UNAME=?,UPWD=?,UORG=? where id=?";

        Object[] objects = new Object[4];
        objects[3] = user.getId();
        objects[0] = user.getuName();
        objects[1] = user.getuPwd();
        objects[2] = user.getuOrg();
       return jdbcTemplate.update(sql, objects);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public String deleteUserById(int id) {
        String sql = "delete from Report_User where id=" + id;
        jdbcTemplate.update(sql);
        return "delete ok";
    }

}
