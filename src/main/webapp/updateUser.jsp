<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
    <link rel="stylesheet" href="css/addUser.css">
</head>
<body>
<div class="container">
    <h2>修改用户信息</h2>
    <div class = "container_main">
        <form action="${pageContext.request.contextPath}/UpdateUserServlet" method="post">
            <div class="form-group">
                <label>学号：</label>
                <input type="text" class="form-control" id="userid" name="userid" value="${requestScope.user.userid}" readonly>
            </div>


            <div class="form-group">
                <label>姓名：</label>
                <input type="text" class="form-control" id="username" name="username" value="${requestScope.user.username}">
            </div>

            <div class="form-group">
                <label >密码：</label>
                <input type="text" class="form-control" id="password" name="password" value="${requestScope.user.password}">
            </div>

            <div class="form-group">
                <label >手机号：</label>
                <input type="text" class="form-control" id="tel" name="tel" value="${requestScope.user.tel}">
            </div>

            <div class="form-group">
                <label >邮箱：</label>
                <input type="text" class="form-control" id="email" name="email" value="${requestScope.user.email}">
            </div>

            <div class="btn">
                <input class ="add-btn"  type="submit" value="修改">
            </div>
        </form>

    </div>

</div>
</body>
</html>
