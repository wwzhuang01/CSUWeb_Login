
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动态码登录</title>
    <link rel="stylesheet" href="css/login.css">
    <script src="js/loginDynamic.js"></script>

    <link rel="stylesheet" href="css/slickList.css">
    <script src="js/slideList.js"></script>
    <script src="js/animate.js"></script>

</head>
<body>

<div class="container">
    <div class="logo">
        <img src="images/logo.png"><span>统一身份认证</span>
    </div>

    <div class="focus">
        <!-- 左侧按钮 -->
        <a href="javascript:;" class="arrow-l">
            &lt;
        </a>
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



    <div class="main">
        <div class="mainbody">
            <section class="maincon">
                <div class="tabHead" style="">
                    <span id="pwdLoginSpan" class="" style="width: 50%;"><a id="userNameLogin_a"  class="loginFont_a" href="${pageContext.request.contextPath}/index.jsp">账号登录</a></span>
                    <span id="phoneLoginSpan" class="selected_underline active" style="width: 50%;"><a id="dynamicLogin_a"  class="loginFont_a">动态码登录</a></span>

                </div>
                <div class="login-pc">
                    <!-- fido登录 -->
                    <!-- 手机动态码登录 -->
                    <div id="phoneLoginDiv" style=""><div>
                    <div class="methods">
                    </div>
                    <form class="loginFromClass" method="post" id="phoneFromId" action="${pageContext.request.contextPath}/LoginDynamicServlet">
                        <div>
                            <div class="form">
                                <!-- 动态码登录 -->
                                <div class="m-phone">
                                <div class="username item" id="loginSelectArea">
                                    <span class="prex-icon"><img src="images/user1.png" class="login-icon"></span>
                                    <input type="text" id="usertel" name="usertel" autocomplete="off" placeholder="请输入手机号/邮箱" title="请输入手机号/邮箱" value=""></div>
                                <div class="captcha item" id="captchaDiv_code">
                                    <span class="prex-icon"><img src="images/captcha1.png" class="login-icon"></span>
                                    <input type="text" id="captcha" name="captcha" placeholder="请输入验证码" title="请输入验证码" maxlength="10"><img class="captcha-img" id = "captcha-img" src="/LoginPro_war_exploded/CreateCode">
								<img id="captchaImg" alt="验证码错误" height="30px" src="./统一身份认证平台2_files/getCaptcha.htl"><a class="mask-inner captcha-refresh" onclick="reloadCaptcha(true)" href="javascript:void(0);">刷新</a>
							</img>
                                </div>
                                <div class="code item">
                                    <span class="prex-icon"><img src="images/pass1.png" class="login-icon"></span>
                                    <i class="auth_icon auth_icon_bar"></i>
                                    <input type="text" id="DCode" name="DCode" placeholder="请输入短信或邮箱动态码" title="请输入短信或邮箱动态码" maxlength="10">
                                    <a class="get-code" href="javascript:void(0)"><em id = "getCodeText" class="getCodeText">获取动态码</em></a>
                                </div>
                            </div>
                            </div>
                            <div id="formErrorTip" class="form-errorTip">
                                ${sessionScope.email_error}
                                <span id="showErrorTip" class="form-error  text-ellipsis">${requestScope.DCode_error}</span>
                                <span id="showWarnTip" class="form-error  text-ellipsis"></span>

                            </div>
                            <div class="btn">
                                <input class ="login-btn"  type="submit" value="登录">
                            </div>
                        </div>
                    </form>
                </div></div>
                    <!-- 用户名密码登录 -->

                    <!-- 账户激活|忘记密码 -->
                    <div class="help">
                    <a id="retrievePassId" href="https://ca.csu.edu.cn/retrieve-password/retrievePassword/index.html#/?service=http%3A%2F%2Fmy.csu.edu.cn%2Flogin%2Findex.jsp" class="fo-password" title="通过手机短信、邮件方式找回密码">忘记密码</a>
                    <div class="activation-account">
                        <span class="activation-account">&nbsp;|&nbsp;</span>
                        <a id="activationAccountId" href="https://ca.csu.edu.cn/retrieve-password/accountActivation/index.html#/?service=http%3A%2F%2Fmy.csu.edu.cn%2Flogin%2Findex.jsp" class="activation-account">账号激活</a>
                    </div>
                </div>
                    <div class="help">
                        <a id="zhsshu" target="_blank" style="text-decoration: none;font-size: 14px;color: #73757E;" href="https://ca.csu.edu.cn/emap/sys/zndxzhss/*default/indexsq.do" title="无法通过手机短信、邮件方式找回密码">账号申诉</a>
                        <a id="zhsqing" target="_blank" style="position: absolute;right: 0;text-decoration: none;font-size: 14px;color: #0c4af9;" href="https://ca.csu.edu.cn/emap/sys/zndxzhsq/*default/indexsq.do">账号申请</a>
                    </div>
                </div>



            </section>


            <div class="footer">
                <div id="qtdlfs" style="color: #0c4af9;min-width: 100px;float: left;margin-right: 10px;">其他登录方式</div>
                <div class="ways">
                    <div class="item">
                        <a id="combinedLogin_a_qq" href="https://ca.csu.edu.cn/authserver/combinedLogin.do?type=qq&amp;success=http%3A%2F%2Fmy.csu.edu.cn%2Flogin%2Findex.jsp">
                            <img src="images/qq.png" alt=""></a>
                    </div>
                </div>
                <div class="ways">
                    <div class="item">
                        <a id="combinedLogin_a_weiXin" href="https://ca.csu.edu.cn/authserver/combinedLogin.do?type=weixin&amp;success=http%3A%2F%2Fmy.csu.edu.cn%2Flogin%2Findex.jsp">
                            <img src="images/weixin.png" alt=""></a>
                    </div>
                </div>
            </div>
        </div>
        <p class="banquan">版权所有 © 2020 中南大学信息与网络中心. 保留所有权利技术支持：0731-88830426  邮箱地址：app@csu.edu.cn</p>
    </div>

</div>






</body>
</html>
