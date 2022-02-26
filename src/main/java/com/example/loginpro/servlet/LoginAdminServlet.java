package com.example.loginpro.servlet;

import com.example.loginpro.entity.Admin;
import com.example.loginpro.service.AdminService;
import com.example.loginpro.service.impl.AdminServiceImpl;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginAdminServlet", value = "/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 收参
        String adminid = request.getParameter("adminid");
        String password = request.getParameter("password");

        // 调用业务逻辑
        AdminService adminService = new AdminServiceImpl();
        Admin admin = adminService.login(adminid,password);

        // 处理结果
        //PrintWriter printWriter = response.getWriter();
        HttpSession session = request.getSession();
        if(admin!=null){     // 用户存在

            // 保存用户名字
            session.setAttribute("admin",admin);
            session.setAttribute("adminname",admin.getAdminname());
            // 跳转到登录成功的页面
            response.sendRedirect(request.getContextPath() +"/successAdmin.jsp");

        }
        else{       // 用户不存在，提示错误信息
            request.setAttribute("login_error","您提供的账号或者密码有误");
            request.getRequestDispatcher("/AdminServlet").forward(request,response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
