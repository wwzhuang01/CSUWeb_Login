package com.example.loginpro.servlet;

import com.example.loginpro.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginDynamicServlet", value = "/LoginDynamicServlet")
public class LoginDynamicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        String rightCode = (String) session.getAttribute("rightDCode");
        String code = request.getParameter("DCode");

        User user = (User) session.getAttribute("user");
        if(rightCode.equals(code)){
            // 动态码输入正确
            // 保存用户名字
            session.setAttribute("username",user.getUsername());
            if(session.getAttribute("DCode_error")!=null)session.removeAttribute("DCode_error");
            // 跳转到登录成功的页面
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        }
        else{
            request.setAttribute("DCode_error","您输入的动态码有误");
            request.getRequestDispatcher("/loginDynamic.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
