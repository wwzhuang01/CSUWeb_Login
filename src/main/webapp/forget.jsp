<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记密码</title>
    <link rel="stylesheet" href="css/forget.css">
    <script src="js/forget.js"></script>
</head>
<body>
<div class = "container">
    <section class="maincon">
        <div class="tabHead" style="">
            <span id="pwdLoginSpan" class="" style="width: 50%;"><a id="userNameLogin_a"  class="loginFont_a" >忘记密码</a></span>
        </div>
        <div class="login-pc">
            <div id="phoneLoginDiv" style=""><div>
                <div class="methods">
                </div>
                <form class="loginFromClass" method="post" id="phoneFromId" action="${pageContext.request.contextPath}/SubmitNewCode">
                    <div>
                        <div class="form">
                            <div class="m-phone">
                                <div class="username item">
                                    <span class="prex-icon"><img src="images/user1.png" class="login-icon"></span>
                                    <input type="text" id="userid" name="userid" autocomplete="off" placeholder="请输入学号/工号" title="请输入学号/工号" value=""></div>

                                <div class="username item">
                                    <span class="prex-icon"><img src="images/user1.png" class="login-icon"></span>
                                    <input type="text" id="usertel" name="usertel" autocomplete="off" placeholder="请输入手机号/邮箱" title="请输入手机号/邮箱" value=""></div>

                                <div class="captcha item">
                                    <span class="prex-icon"><img src="images/captcha1.png" class="login-icon"></span>
                                    <input type="text" id="captcha" name="captcha" placeholder="请输入验证码" title="请输入验证码" maxlength="10"><img class="captcha-img" id = "captcha-img" src="/LoginPro_war_exploded/CreateCode"></div>


                                <div class="code item">
                                    <span class="prex-icon"><img src="images/pass1.png" class="login-icon"></span>
                                    <i class="auth_icon auth_icon_bar"></i>
                                    <input type="text" id="DCode" name="DCode" placeholder="请输入短信或邮箱动态码" title="请输入短信或邮箱动态码" maxlength="10">
                                    <a class="get-code" href="javascript:void(0)"><em id = "getCodeText" class="getCodeText">获取动态码</em></a>
                                </div>

                                <div class="username item">
                                    <span class="prex-icon"><img src="images/pass1.png" class="login-icon"></span>
                                    <input type="password" id="newpsw1" name="newpsw1" autocomplete="off" placeholder="请输入新的密码" title="请输入新的密码" value="">

                                </div>

                                <div class="username item">
                                    <span class="prex-icon"><img src="images/pass1.png" class="login-icon"></span>
                                    <input type="password" id="newpsw2" name="newpsw2" autocomplete="off" placeholder="请重复输入密码" title="请重复输入密码" value="">

                                </div>




                            </div>
                        </div>
                        <div id="formErrorTip" class="form-errorTip">
                            ${sessionScope.email_error}
                            <span id="showErrorTip" class="form-error  text-ellipsis">${requestScope.DCode_error}</span>

                        </div>
                        <div class="btn">
                            <input class ="login-btn"  type="submit" value="提交">
                        </div>
                    </div>
                </form>
            </div></div>

        </div>

    </section>


</div>
</body>
</html>
