<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户首页</title>
    <link rel="stylesheet" href="css/success.css">

</head>
<body>
<div class = "container">
    <h2>${sessionScope.username},你好呀！</h2>
    <div class = "bt"><a href="${pageContext.request.contextPath}/updatePsw.jsp">修改密码</a></div>
    <div class = "bt"><a href="${pageContext.request.contextPath}/index.jsp">退出账户</a></div>

</div>
</body>
</html>
