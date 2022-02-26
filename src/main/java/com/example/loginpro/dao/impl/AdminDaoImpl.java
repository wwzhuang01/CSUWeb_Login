package com.example.loginpro.dao.impl;

import com.example.loginpro.dao.AdminDao;
import com.example.loginpro.entity.Admin;
import com.example.loginpro.entity.User;
import com.example.loginpro.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    private QueryRunner queryRunner = new QueryRunner();


    @Override
    public Admin select(String adminid) {
        Admin admin = new Admin();// 能够执行
        try {
            admin = queryRunner.query(DbUtils.getConnection(),"select * from admin where adminid=?",new BeanHandler<Admin>(Admin.class),adminid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

}
