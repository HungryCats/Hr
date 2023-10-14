<%@ page import="com.cats.pojo.Brand" %><%--
  Created by IntelliJ IDEA.
  User: Wings
  Date: 2023/5/17
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改</title>
    <link rel="stylesheet" type="text/css" href="./css/updateBrand.css">
</head>
<%
    Brand brand = (Brand) request.getAttribute("brand");
%>
<body>
<div class="update">
    <form action="brandServlet?method=updateBrand" method="post">
        <h1>修改</h1>
        <input type="hidden" name="id" value="<%=brand.getId()%>">
        <div class="box">
            <label>
                <input type="text" name="name" value=<%=brand.getName()%> placeholder="用户名">
            </label>
        </div>
        <div class="box">
            <label>
                <input type="text" name="pwd" value=<%=brand.getPwd()%> placeholder="密码">
            </label>
        </div>
        <div class="box">
            <label>
                <input type="text" name="money" value=<%=brand.getMoney()%> placeholder="金额">
            </label>
        </div>
        <div class="box">
            <input type="submit" value="修改" class="xg">
        </div>
    </form>
</div>
</body>
</html>
