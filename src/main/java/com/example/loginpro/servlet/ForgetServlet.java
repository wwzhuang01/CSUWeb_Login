package com.example.loginpro.servlet;

import com.example.loginpro.entity.User;
import com.example.loginpro.service.UserService;
import com.example.loginpro.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static com.example.loginpro.utils.MailUtil.generateRandomCode;
import static com.example.loginpro.utils.MailUtil.sendMail;
import static com.example.loginpro.utils.PhoneUtil.generateTelCode;
import static com.example.loginpro.utils.PhoneUtil.sendCode;

@WebServlet(name = "ForgetServlet", value = "/ForgetServlet")
public class ForgetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        // 收参
        String userid = request.getParameter("userid");
        String usertel = request.getParameter("usertel");
        String captcha = request.getParameter("captcha");
        String rightDCode = (String) session.getAttribute("codes");

        // 判断验证码、学号、手机号，然后获取动态码
        if(rightDCode.equalsIgnoreCase(captcha)){
            UserService userService = new UserServiceImpl();
            // 判断学号
            User user = userService.haveId(userid);
            if(user!=null){
                session.setAttribute("user",user);
                int pos = usertel.indexOf('@');
                if(pos>=0){     // 输入的是邮箱
                    String rightTel = user.getEmail();
                    if(rightTel.equals(usertel)){
                        System.out.println("存在该用户，可以发送动态码了");
                        String code = generateRandomCode(6);
                        sendMail(usertel,code);
                        session.setAttribute("rightDCode",code);
                        session.setAttribute("user",user);
                    }

                    else{
                        System.out.println("您提供的邮箱有误");
                        response.getWriter().write("您提供的邮箱有误");

                    }
                }
                else{           // 输入的是手机号
                    String rightTel = user.getTel();
                    if(rightTel.equals(usertel)){
                        String telcode = generateTelCode(6);
                        try {
                            String sendCoderes = sendCode(usertel,"",telcode);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        session.setAttribute("rightDCode",telcode);
                        session.setAttribute("user",user);
                    }
                    else{
                        System.out.println("您提供的手机号有误");
                        response.getWriter().write("您提供的手机号有误");

                    }
                }
            }
            else{
                System.out.println("输入的学号不存在");
                response.getWriter().write("您输入的学号有误");
            }

        }
        else{
            System.out.println("您输入的验证码有误");
            //request.setAttribute("VCode_error","您输入的验证码有误");
            response.getWriter().write("您提供的验证码有误");
            //request.getRequestDispatcher("/loginDynamic.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
