<%--
  Created by IntelliJ IDEA.
  User: Wings
  Date: 2023/5/17
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="./css/login.css">
</head>
<body>
<div class="login">
    <form action="userServlet?method=login" method="post">
        <h1>用户登录</h1>
        <div class="box">
            <label for="username"></label><input id="username" name="username" type="text" value="${cookie.username.value}" placeholder="账号：">
        </div>
        <div class="box">
            <label for="password"></label><input id="password" name="password" type="text" value="${cookie.password.value}" placeholder="密码：">
        </div>
        <div>
            <a href="register.jsp">注册</a>
            <label style="color: #41b3ff; padding-left: 280px;"><input name="remember" value="1" type="checkbox" style="height: 16px; width: 16px; vertical-align:middle;" checked>记住用户</label>
        </div>
        <div class="box">
            <input type="submit" value="登录" class="dl">
        </div>
    </form>
</div>
</body>
</html>
