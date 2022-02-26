package com.example.loginpro.servlet;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/*
 * 用于创建验证码图片
 */
@WebServlet(name = "CreateCode", value = "/CreateCode")
public class CreateCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建验证码图片
        ValidateCode code = new ValidateCode(200,80,4,20);
        String codes = code.getCode();
        System.out.println("正确的验证码为：" + codes);
        HttpSession session = request.getSession();
        session.setAttribute("codes",codes);        // 将验证码存储在session中的codes属性
        //2.验证码图片响应给客户端
        code.write(response.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
