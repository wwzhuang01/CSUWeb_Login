package com.example.loginpro.service.impl;

import com.example.loginpro.dao.AdminDao;
import com.example.loginpro.dao.UserDao;
import com.example.loginpro.dao.impl.AdminDaoImpl;
import com.example.loginpro.dao.impl.UserDaoImpl;
import com.example.loginpro.entity.Admin;
import com.example.loginpro.entity.User;
import com.example.loginpro.service.AdminService;
import com.example.loginpro.utils.DbUtils;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin login(String adminid, String password) {
        DbUtils.begin();
        Admin resAdmin = null;
        Admin admin = adminDao.select(adminid);
        if(admin!=null){         // 如果存在该用户id
            if(admin.getPassword().equals(password))     // 且密码正确
                resAdmin = admin;
        }
        DbUtils.commit();       // 整个事务完成，进行事务提交

        return resAdmin;
    }

}
