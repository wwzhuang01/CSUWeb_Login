package com.example.loginpro.servlet;

import com.example.loginpro.dao.UserDao;
import com.example.loginpro.dao.impl.UserDaoImpl;
import com.example.loginpro.entity.User;
import com.example.loginpro.service.UserService;
import com.example.loginpro.service.impl.UserServiceImpl;

import javax.crypto.spec.PSource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static com.example.loginpro.utils.MailUtil.generateRandomCode;
import static com.example.loginpro.utils.MailUtil.sendMail;
import static com.example.loginpro.utils.PhoneUtil.generateTelCode;
import static com.example.loginpro.utils.PhoneUtil.sendCode;

/*
 * 点击获取动态码后进行验证及反馈
 */
@WebServlet(name = "getDynamicCode", value = "/getDynamicCode")
public class getDynamicCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("跳转到getDynamicCode");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取数据
        String usertel = request.getParameter("usertel");
        String captcha = request.getParameter("captcha");

        // 进行业务处理：先判断验证码是否正确，然后判断手机号是否正确（是手机号还是邮箱）；如果正确，就发送动态码，否则返回一个错误提示消息
        HttpSession session = request.getSession();
        String rightDCode = (String) session.getAttribute("codes");
        System.out.println("正确的验证码：" + rightDCode);

        if(rightDCode.equalsIgnoreCase(captcha)){
            System.out.println("验证码正确");
            // 判断是手机号还是邮箱
            int pos = usertel.indexOf('@');
            UserService userService = new UserServiceImpl();
            if(pos>=0){     // 输入的是邮箱
                User user = userService.haveEmail(usertel);
                if(user!=null){
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
                System.out.println("检测是否存在手机号");
                User user = userService.haveTel(usertel);
                if(user!=null){
                    System.out.println("存在该用户，可以发送动态码了");
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
            System.out.println("您输入的验证码有误");
            //request.setAttribute("VCode_error","您输入的验证码有误");
            response.getWriter().write("您提供的验证码有误");
            //request.getRequestDispatcher("/loginDynamic.jsp").forward(request,response);
        }

        //response.getWriter().write("您提供的邮箱有误");
        System.out.println(usertel + " " + captcha);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
