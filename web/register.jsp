<%--
  Created by IntelliJ IDEA.
  User: Wings
  Date: 2023/5/18
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="./css/register.css">
</head>
<body>

<div class="register">
    <form action="userServlet?method=register" method="post">
        <h1>用户注册</h1><br>
        <span style="text-align: center;display:block;">${register_msg}</span><br>
        <table>
            <tr class="box">
                <td>
                    <label>
                        <input name="username" type="text" placeholder="账号">
                    </label>
                </td>
            </tr>
            <tr class="box">
                <td>
                    <label>
                        <input name="password" type="text" placeholder="密码">
                    </label>
                </td>
            </tr>
        </table>
        <div class="box">
            <input type="submit" value="注册" class="zc">
        </div>
    </form>
</div>
</body>
</html>