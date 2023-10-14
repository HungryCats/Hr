<%--
  Created by IntelliJ IDEA.
  User: Wings
  Date: 2023/5/8
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>404</title>
  <style>*, *::after, *::before {
    box-sizing: border-box;
  }

  html {
    background: #000;
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  }

  head {
    display: block;
    position: relative;
    width: 200px;
    margin: 10% auto 0;
    -webkit-animation: shvr 0.2s infinite;
    animation: shvr 0.2s infinite;
  }
  head::after {
    content: '';
    width: 20px;
    height: 20px;
    background: #000;
    position: absolute;
    top: 30px;
    left: 25px;
    border-radius: 50%;
    box-shadow: 125px 0 0 #000;
    -webkit-animation: eye 2.5s infinite;
    animation: eye 2.5s infinite;
  }

  meta {
    position: relative;
    display: inline-block;
    background: #fff;
    width: 75px;
    height: 80px;
    border-radius: 50% 50% 50% 50%/45px 45px 45% 45%;
    transform: rotate(45deg);
  }
  meta::after {
    content: '';
    position: absolute;
    border-bottom: 2px solid #fff;
    width: 70px;
    height: 50px;
    left: 0px;
    bottom: -10px;
    border-radius: 50%;
  }
  meta::before {
    bottom: auto;
    top: -100px;
    transform: rotate(45deg);
    left: 0;
  }
  meta:nth-of-type(2) {
    float: right;
    transform: rotate(-45deg);
  }
  meta:nth-of-type(2)::after {
    left: 5px;
  }
  meta:nth-of-type(3) {
    display: none;
  }

  body {
    margin-top: 100px;
    text-align: center;
    color: #fff;
  }
  body::before {
    content: '404';
    font-size: 80px;
    font-weight: 800;
    display: block;
    margin-bottom: 10px;
  }
  body::after {
    content: 'Got lost? How.....?  why.....?  Ahhhh....';
    color: #1EA7AB;
    width: 120px;
    font-size: 30px;
    overflow: hidden;
    display: inline-block;
    white-space: nowrap;
    -webkit-animation: text-show 2s infinite steps(3);
    animation: text-show 2s infinite steps(3);
  }
  @-webkit-keyframes eye {
    0% ,30% , 55%, 90% , 100% {
      transform: translate(0, 0);
    }
    10%, 25% {
      transform: translate(0, 20px);
    }
    65% {
      transform: translate(-20px, 0);
    }
    80% {
      transform: translate(20px, 0);
    }
  }
  @keyframes eye {
    0% ,30% , 55%, 90% , 100% {
      transform: translate(0, 0);
    }
    10%, 25% {
      transform: translate(0, 20px);
    }
    65% {
      transform: translate(-20px, 0);
    }
    80% {
      transform: translate(20px, 0);
    }
  }
  @-webkit-keyframes shvr {
    0% {
      transform: translate(1px, 1em);
    }
    50% {
      transform: translate(0, 1em);
    }
    100% {
      transform: translate(-1px, 1em);
    }
  }
  @keyframes shvr {
    0% {
      transform: translate(1px, 1em);
    }
    50% {
      transform: translate(0, 1em);
    }
    100% {
      transform: translate(-1px, 1em);
    }
  }
  @-webkit-keyframes text-show {
    to {
      text-indent: -373px;
    }
  }
  @keyframes text-show {
    to {
      text-indent: -373px;
    }
  }
  </style>
</head>
<body>
<h1>用户名或密码错误</h1>
<a href="login.jsp">跳转...</a>
</body>
</html>
