<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <link rel="stylesheet" href="css/addUser.css">
</head>
<body>
<div class="container">
    <h2>添加用户</h2>
    <div class = "container_main">
        <form action="${pageContext.request.contextPath}/AddUserServlet" method="post">
            <div class="form-group">
                <label>学号：</label>
                <input type="text" class="form-control" id="userid" name="userid" placeholder="请输入学号">
            </div>

            <div class="form-group">
                <label>姓名：</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="请输入姓名">
            </div>

            <div class="form-group">
                <label >密码：</label>
                <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
            </div>

            <div class="form-group">
                <label >手机号：</label>
                <input type="text" class="form-control" id="tel" name="tel" placeholder="请输入手机号">
            </div>

            <div class="form-group">
                <label >邮箱：</label>
                <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱">
            </div>
            <div class = "error">
                &nbsp;&nbsp;
                ${requestScope.error}
            </div>
            <div class="btn">
                <input class ="add-btn"  type="submit" value="添加">
            </div>
        </form>

    </div>

</div>
</body>
</html>
