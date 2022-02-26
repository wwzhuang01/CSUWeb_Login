package com.example.loginpro.servlet;

import com.example.loginpro.entity.User;
import com.example.loginpro.service.UserService;
import com.example.loginpro.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 接收参数
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        // 调用业务逻辑
        UserService userService = new UserServiceImpl();
        User user = userService.login(userid,password);

        // 处理结果
        HttpSession session = request.getSession();
        if(user!=null){     // 用户存在
            // 保存用户名字
            session.setAttribute("user",user);
            session.setAttribute("username",user.getUsername());
            // 跳转到登录成功的页面
            response.sendRedirect(request.getContextPath() + "/success.jsp");

        }
        else{       // 用户不存在，提示错误信息
            request.setAttribute("login_error","您提供的用户名或者密码有误");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
