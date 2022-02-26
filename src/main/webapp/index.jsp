
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/slickList.css">
    <script src="js/slideList.js"></script>
    <script src="js/animate.js"></script>

</head>
<body>
<div class = "container">
    <%--    左上角的logo --%>
    <div class = "logo">
        <img src="images/logo.png" alt="">
        <span>统一身份认证</span>
    </div>

    <%--   左侧的轮播图 --%>
    <div class="focus">
        <!-- 左侧按钮 -->
        <a href="javascript:;" class="arrow-l">&lt;</a>
        <!-- 右侧按钮 -->
        <a href="javascript:;" class="arrow-r">&gt;</a>
        <!-- 核心的滚动区域 -->
        <ul>
            <li>
                <a href="#"><img src="images/pic1.jpg" alt=""></a>
            </li>
            <li>
                <a href="#"><img src="images/pic2.png" alt=""></a>
            </li>
            <li>
                <a href="#"><img src="images/pic3.jpg" alt=""></a>
            </li>
            <li>
                <a href="#"><img src="images/pic4.jpg" alt=""></a>
            </li>
        </ul>
        <!-- 小圆圈 -->
        <ol class="circle">

        </ol>
    </div>


    <%--  登录表单 --%>
    <div class = "main">
        <div class = "mainbody">
            <section class = "maincon">
                <%-- 供选择登录方式   --%>
                <div class = "tabHead">
                    <span id="pwdLoginSpan" class="active selected_underline" style="width: 50%;"><a id="userNameLogin_a" href="#" class="loginFont_a">账号登录</a></span>
                    <span id="phoneLoginSpan" style="width: 50%;"><a id="dynamicLogin_a" href="${pageContext.request.contextPath}/loginDynamic.jsp" class="loginFont_a">动态码登录</a></span>
                </div>

                <div class="login-pc">
                    <%--   最主要的输入部分   --%>
                    <div id="pwdLoginDiv" style="">
                        <div>
                            <form class="loginFromClass" method="post" id="pwdFromId" action="${pageContext.request.contextPath}/LoginServlet">
                                <div class="form">
                                    <!-- 用户名密码登录 -->
                                    <div class="m-account">
                                        <div class="username item">
                                            <span class="prex-icon"><img src="images/user1.png" class="login-icon"></span>
                                            <input id="userid" name="userid" type="text" placeholder="请输入学号/工号" title="请输入学号/工号" value=""></div>
                                        <div class="password item">
                                            <span class="prex-icon"><img src="images/pass1.png" class="login-icon"></span>
                                            <input id="password" name="password" type="password" placeholder="请输入密码" title="请输入密码"><input id="saltPassword" name="password" type="hidden"></div>

                                    </div>
                                    <%--   7天免登录--%>
                                    <div class="m-rememberMe">
                                        <input type="checkbox" name="rememberMe" id="rememberMe" value="true" style="width:15px;margin-right:5px;"><span>7天免登录</span>
                                    </div>

                                </div>
                                <%--   提示输入的信息错误--%>
                                <div id="formErrorTip" class="form-errorTip">
                                    <span id="showErrorTip" class="form-error text-ellipsis">${requestScope.login_error}</span>
                                </div>
                                <%--  登录按钮--%>
                                <div class="btn">
                                    <input class ="login-btn"  type="submit" value="登录">
                                </div>
                        </div>
                        </form>

                    </div>

                    <!-- 账户激活|忘记密码 -->
                    <div class="help">
                        <a id="retrievePassId"  class="fo-password" title="通过手机短信、邮件方式找回密码" href = "${pageContext.request.contextPath}/forget.jsp">忘记密码</a>
                        <div class="activation-account">
                            <span class="activation-account">&nbsp;|&nbsp;</span>
                            <a id="activationAccountId" class="activation-account">账号激活</a>
                        </div>
                    </div>
                    <%-- 账号申诉|账号申请--%>
                    <div class="help">
                        <a id="zhsshu" target="_blank" style="text-decoration: none;font-size: 14px;color: #73757E;" title="无法通过手机短信、邮件方式找回密码">账号申诉</a>
                        <a id="zhsqing" target="_blank" style="position: absolute;right: 0;text-decoration: none;font-size: 14px;color: #0c4af9;" >账号申请</a>
                    </div>
                </div>
            </section>

            <%-- 其他登录方式--qq和微信--%>
            <div class="footer">
                <div style="color: #0c4af9;min-width: 100px;float: left;margin-right: 10px;">其他登录方式</div>
                <div class="ways">
                    <div class="item">
                        <a><img src="images/qq.png" alt=""></a>
                    </div>
                </div>
                <div class="ways">
                    <div class="item">
                        <a><img src="images/weixin.png" alt=""></a>
                    </div>
                </div>
            </div>
        </div>

        <p class="banquan">
            版权所有 © 2020 中南大学信息与网络中心. 保留所有权利技术支持：0731-88830426 邮箱地址：app@csu.edu.cn
        </p>

    </div>

    <div class = "adminLogin">
        <a href="${pageContext.request.contextPath}/adminLogin.jsp">管理员登录</a>
    </div>



</div>
</body>
</html>
