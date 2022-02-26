package com.example.loginpro.servlet;

import com.example.loginpro.entity.User;
import com.example.loginpro.service.UserService;
import com.example.loginpro.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdatePsw", value = "/UpdatePsw")
public class UpdatePsw extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        String newpsw1 = request.getParameter("newpsw1");
        String newpsw2 = request.getParameter("newpsw2");

        User user = (User) session.getAttribute("user");

        if(newpsw1.equals(newpsw2)){
            UserService userService = new UserServiceImpl();
            int res = userService.updatePsw(user.getUserid(),newpsw1);
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        }
        else{
            request.setAttribute("error","您两次输入的密码不同");
            request.getRequestDispatcher("/updatePsw.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
