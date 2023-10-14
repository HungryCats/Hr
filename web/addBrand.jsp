<%--
  Created by IntelliJ IDEA.
  User: Wings
  Date: 2023/5/17
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>新增</title>
    <link rel="stylesheet" type="text/css" href="./css/addBrand.css">
</head>
<body>
<div class="add">
    <form action="brandServlet?method=addBrand" method="post">
        <h1>新增</h1>
        <div class="box">
            <input type="text" name="name" placeholder="用户名">
        </div>
        <div class="box">
            <input type="text" name="pwd" placeholder="密码">
        </div>
        <div class="box">
            <input type="text" name="money" placeholder="金额">
        </div>
        <div class="box">
            <input type="submit" value="添加" class="tj">
        </div>
    </form>
</div>
</body>
</html>
