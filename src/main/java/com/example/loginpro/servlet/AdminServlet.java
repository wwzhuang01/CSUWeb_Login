package com.example.loginpro.servlet;

import com.example.loginpro.entity.User;
import com.example.loginpro.service.UserService;
import com.example.loginpro.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {         // 产生所有用户
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 加载得到所有的用户信息
        UserService userService = new UserServiceImpl();
        List<User> user = userService.showAllUser();

        //创建Jackson的核心对象  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        System.out.println(json);
        HttpSession session = request.getSession();
        session.setAttribute("json",json);
        session.setAttribute("users",user);
        request.getRequestDispatcher("/admin.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
