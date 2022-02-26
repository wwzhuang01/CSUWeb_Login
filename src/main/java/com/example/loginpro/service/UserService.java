package com.example.loginpro.service;

import com.example.loginpro.entity.User;

import java.util.List;

public interface UserService {
    public User login(String userid, String password);
    public List<User> showAllUser();
    public List<User> showPartUser(User user);
    public User haveEmail(String email);
    public User haveTel(String tel);
    public User haveId(String userid);
    public int updatePsw(String userid,String password);
    public int updateUser(User user);
    public int add(User user);
    public void delete(String userid);
}
