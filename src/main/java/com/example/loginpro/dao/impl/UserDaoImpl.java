package com.example.loginpro.dao.impl;

import com.example.loginpro.dao.UserDao;
import com.example.loginpro.entity.User;
import com.example.loginpro.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public int delete(String userid) {
        try {
            queryRunner.update(DbUtils.getConnection(),
                    "DELETE FROM user where userid = ?",userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(String userid, String password) {
        User user = select(userid);
        int res = 0;
        try {

            res = queryRunner.update(DbUtils.getConnection(),"update user set password=? where userid = ?",password,userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int updatename(String userid, String username) {
        User user = select(userid);
        try {
            queryRunner.update(DbUtils.getConnection(),"update user set username=? where userid = ?",username,userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateTel(String userid, String tel) {
        User user = select(userid);
        try {
            queryRunner.update(DbUtils.getConnection(),"update user set tel=? where userid = ?",tel,userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateEmail(String userid, String email) {
        User user = select(userid);
        try {
            queryRunner.update(DbUtils.getConnection(),"update user set email=? where userid = ?",email,userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



    @Override
    public int add(User user) {
        int res = 0;
        try {
            res = queryRunner.update(DbUtils.getConnection(),"INSERT INTO user values(?,?,?,?,?)",user.getUserid(),user.getUsername(),user.getPassword(),user.getTel(),user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public User select(String userid){
        User user = new User();// 能够执行
        try {
            user = queryRunner.query(DbUtils.getConnection(),"select * from user where userid=?",new BeanHandler<User>(User.class),userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = null;
        try {
            users = queryRunner.query(DbUtils.getConnection(),"select * from user;",new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User selectByTel(String tel) {
        User user = new User();// 能够执行
        try {
            user = queryRunner.query(DbUtils.getConnection(),"select * from user where tel=?",new BeanHandler<User>(User.class),tel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User selectByEmail(String email) {
        User user = new User();// 能够执行
        try {
            user = queryRunner.query(DbUtils.getConnection(),"select * from user where email=?",new BeanHandler<User>(User.class),email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    @Override
    public List<User> selectPart(User user) {
        List<User> users = null;
        String sql = "select * from user where";
        sql += " userid like \"%" + user.getUserid() + "%\" ";
        sql += "and username like \"%" + user.getUsername() + "%\" ";
        sql += "and tel like \"%" + user.getTel() + "%\" ";
        sql += "and email like \"%" + user.getEmail() + "%\" ";

        try {
            users = queryRunner.query(DbUtils.getConnection(),sql,new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}

