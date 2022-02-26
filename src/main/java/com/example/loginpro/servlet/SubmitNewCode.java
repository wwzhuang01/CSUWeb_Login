package com.example.loginpro.servlet;

import com.example.loginpro.entity.User;
import com.example.loginpro.service.UserService;
import com.example.loginpro.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SubmitNewCode", value = "/SubmitNewCode")
public class SubmitNewCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        String rightCode = (String) session.getAttribute("rightDCode");     // 正确的动态码
        String code = request.getParameter("DCode");        // 输入的动态码
        String newpsw1 = request.getParameter("newpsw1");
        String newpsw2 = request.getParameter("newpsw2");

        User user = (User) session.getAttribute("user");

        if(newpsw1.equals(newpsw2)){
            if(code.equals(rightCode)){
                UserService userService = new UserServiceImpl();
                int res = userService.updatePsw(user.getUserid(),newpsw1);
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
            else{
                request.setAttribute("error","您输入的动态码有误");
                request.getRequestDispatcher("/forget.jsp").forward(request,response);
            }
        }
        else{
            request.setAttribute("error","您两次输入的密码不同");
            request.getRequestDispatcher("/forget.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
