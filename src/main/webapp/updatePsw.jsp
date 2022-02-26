<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link rel="stylesheet" href="css/forget.css">
</head>
<body>
<div class = "container">
    <section class="maincon">
        <div class="tabHead" style="">
            <span id="pwdLoginSpan" class="" style="width: 50%;"><a id="userNameLogin_a"  class="loginFont_a" >修改密码</a></span>
        </div>
        <div class="login-pc">
            <div id="phoneLoginDiv" ><div>
                <div class="methods">
                </div>
                <form class="loginFromClass" method="post" id="phoneFromId" action="${pageContext.request.contextPath}/UpdatePsw">
                    <div>
                        <div class="form">
                            <div class="m-phone">
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

                            <span id="showErrorTip" class="form-error  text-ellipsis">${requestScope.error}</span>


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
