package com.example.loginpro.servlet;

import com.example.loginpro.entity.User;
import com.example.loginpro.service.UserService;
import com.example.loginpro.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectUserServlet", value = "/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        // 获取查询条件参数
        String userid = request.getParameter("userid");        // 输入的动态码
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");

        User user = new User(userid,name,"",tel,email);

        // 查询满足条件的用户
        UserService userService = new UserServiceImpl();
        List<User> users = userService.showPartUser(user);

        //  设置查询条件参数，在页面中显示
        request.setAttribute("condition_userid",userid );
        request.setAttribute("condition_name",name );
        request.setAttribute("condition_tel",tel );
        request.setAttribute("condition_email",email );
        // 设置查询结果参数
        session.setAttribute("users",users);
        request.getRequestDispatcher("/admin.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
