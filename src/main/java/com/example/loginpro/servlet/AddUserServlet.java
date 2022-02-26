package com.example.loginpro.servlet;

import com.example.loginpro.entity.User;
import com.example.loginpro.service.UserService;
import com.example.loginpro.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");

        UserService userService = new UserServiceImpl();
        User user = userService.haveId(userid);
        if(user==null){
            user = new User(userid,username,password,tel,email);
            int res = userService.add(user);
            request.getRequestDispatcher("/AdminServlet").forward(request,response);
        }
        else{
            request.setAttribute("error","输入的学号已存在！");
            request.getRequestDispatcher("/addUser.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
