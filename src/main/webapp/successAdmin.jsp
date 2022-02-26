<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员首页</title>
    <link rel="stylesheet" href="css/success.css">
</head>
<body>
<div class = "container">
    <h2>${sessionScope.adminname},你好呀！</h2>
    <div class = "bt"><a href="${pageContext.request.contextPath}/AdminServlet">查询用户</a></div>
    <div class = "bt"><a href="${pageContext.request.contextPath}/adminLogin.jsp">退出账户</a></div>

</div>
</body>
</html>
