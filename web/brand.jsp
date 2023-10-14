<%@ page import="java.util.List" %>
<%@ page import="com.cats.pojo.Brand" %><%--
  Created by IntelliJ IDEA.
  User: Wings
  Date: 2023/5/17
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="./css/brand.css">
</head>

<%
    List<Brand> brands = (List<Brand>) request.getAttribute("brands");
%>
<body>
<h1 align="center">${user.username},欢迎您</h1>
<button id="add" class="button" style="vertical-align:middle;display:block;margin:0 auto"><span>新增</span></button>
<hr class="hr-solid-content" data-content="分隔线">
<table border="1" cellspacing="0" width="80%">
    <tr align="center">
        <th>序号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>金额</th>
        <th>修改</th>
        <th>删除</th>
    </tr>

    <%
        if (brands != null) {
            for (int i = 0; i < brands.size(); i++) {
                Brand brand = brands.get(i);
    %>

    <tr align="center">
        <td><%=brand.getId()%>
        </td>
        <td><%=brand.getName()%>
        </td>
        <td><%=brand.getPwd()%>
        </td>
        <td><%=brand.getMoney()%>
        </td>
        <td><a href="brandServlet?method=selectById&id=<%=brand.getId()%>">修改</a></td>
        <td><button onclick="myFunction()" style="cursor: pointer; border-style: none">删除</button></td>
    </tr>

    <script>
        document.getElementById("add").onclick = function () {
            location.href = "addBrand.jsp";
        }
        function myFunction() {
            if (confirm("是否删除?")) {
                location.href = "brandServlet?method=deleteById&id=<%=brand.getId()%>";
            }
        }
    </script>

    <%}}%>

</table>

</body>
</html>
