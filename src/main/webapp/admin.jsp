
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理界面</title>
    <link rel="stylesheet" href="css/admin.css">
</head>
<body>
<div class="container">
    <h2>用户信息列表</h2>
    <%--  查询输入部分--%>
    <div class = "select">
        <form class="form-inline" action="${pageContext.request.contextPath}/SelectUserServlet" method="post">
            <div class="form-group">
                <label>学号</label>
                <input  type="text" name="userid" value="${condition_userid}" class="form-control" id="userid" style="width: 80px">
            </div>
            <div class="form-group">
                <label>姓名</label>
                <input type="text" name="name" value="${condition_name}" class="form-control" id="name" style="width: 80px" >
            </div>
            <div class="form-group">
                <label>手机号</label>
                <input type="text" name="tel" value="${condition_tel}" class="form-control" id="tel" style="width: 120px">
            </div>

            <div class="form-group">
                <label>邮箱</label>
                <input type="text" name="email" value="${condition_email}" class="form-control" id="email"  >
            </div>
            <div class="btn">
                <input class ="select-btn"  type="submit" value="查询">
            </div>
        </form>

    </div>



    <%--  展示用户信息列表--%>
    <table  class="table">
            <tr class="thead">
                <th>学号</th>
                <th>姓名</th>
                <th>密码</th>
                <th>手机号</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${sessionScope.users}" var="user" varStatus="s">
                <tr>
                    <td>${user.userid}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.tel}</td>
                    <td>${user.email}</td>
                    <td>
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/UpdateUserF?userid=${user.userid}" >修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/DeleteServlet?userid=${user.userid}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    <div class = "add-btn"><a href="addUser.jsp">添加用户</a></div>
    <div class = "add-btn"><a href="successAdmin.jsp">退出查询</a></div>
</div>









</body>
</html>
