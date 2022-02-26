package com.example.loginpro.dao;

import com.example.loginpro.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {      // 操作数据库的类
    public int delete(String userid);
    public int update(String userid,String password);
    public int updatename(String userid,String username);
    public int updateTel(String userid,String tel);
    public int updateEmail(String userid,String email);

    public int add(User user);      // 注册一个用户
    public User select(String userid) throws SQLException;
    public List<User> selectAll();
    public User selectByTel(String tel);
    public User selectByEmail(String email);
    public List<User> selectPart(User user);
}

