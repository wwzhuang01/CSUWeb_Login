package com.example.loginpro.service.impl;

import com.example.loginpro.dao.impl.UserDaoImpl;
import com.example.loginpro.entity.User;
import com.example.loginpro.service.UserService;
import com.example.loginpro.utils.DbUtils;
import com.example.loginpro.dao.UserDao;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String userid, String password) {     // 登录函数，实现登录业务功能，检测输入的用户id和密码是否正确
        DbUtils.begin();
        User resUser = null;
        try {
            User user = userDao.select(userid);
            if(user!=null){         // 如果存在该用户id

                if(user.getPassword().equals(password))     // 且密码正确
                    resUser = user;

            }
            DbUtils.commit();       // 整个事务完成，进行事务提交
        } catch (SQLException e) {
            DbUtils.rollback();     // 事务出现异常，进行回滚
            e.printStackTrace();
        }

        return resUser;
    }

    @Override
    public List<User> showAllUser() {
        DbUtils.begin();
        List<User> users = null;
        users = userDao.selectAll();

        return users;
    }

    @Override
    public List<User> showPartUser(User user) {
        DbUtils.begin();
        List<User> users = null;
        users = userDao.selectPart(user);

        return users;
    }

    @Override
    public User haveEmail(String email) {
        DbUtils.begin();
        User user = null;
        user = userDao.selectByEmail(email);      // 如果存在，就存储在user中，如果不存在，就为空
        DbUtils.commit();       // 整个事务完成，进行事务提交
        return user;
    }

    @Override
    public User haveTel(String tel) {
        DbUtils.begin();
        User user = null;
        user = userDao.selectByTel(tel);      // 如果存在，就存储在user中，如果不存在，就为空
        DbUtils.commit();       // 整个事务完成，进行事务提交
        return user;
    }
    public User haveId(String userid){
        DbUtils.begin();
        User user = null;
        try {
            user = userDao.select(userid);      // 如果存在，就存储在user中，如果不存在，就为空
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbUtils.commit();       // 整个事务完成，进行事务提交
        return user;
    }

    @Override
    public int updatePsw(String userid, String password) {
        DbUtils.begin();
        int res = userDao.update(userid,password);
        DbUtils.commit();       // 整个事务完成，进行事务提交
        return res;
    }

    @Override
    public int updateUser(User user) {
        DbUtils.begin();
        String userid = user.getUserid();
        userDao.update(userid, user.getPassword());
        userDao.updatename(userid, user.getUsername());
        userDao.updateTel(userid, user.getTel());
        userDao.updateEmail(userid, user.getEmail());
        DbUtils.commit();       // 整个事务完成，进行事务提交

        return 0;
    }

    @Override
    public int add(User user) {
        DbUtils.begin();
        int res = userDao.add(user);
        DbUtils.commit();       // 整个事务完成，进行事务提交
        return res;
    }

    @Override
    public void delete(String userid) {
        DbUtils.begin();
        userDao.delete(userid);
        DbUtils.commit();       // 整个事务完成，进行事务提交
    }

}
