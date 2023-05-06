<%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/4/1
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <style>
    * {
      margin: 0;
      padding: 0;
    }
    html {
      height: 100%;
    }
    body {
      height: 100%;
    }
    .container {
      height: 100%;
      background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
    }
    .login-wrapper {
      background-color: #fff;
      width: 358px;
      height: 588px;
      border-radius: 15px;
      padding: 0 50px;
      position: relative;
      left: 50%;
      top: 50%;
      transform: translate(-50%, -50%);
    }
    .header {
      font-size: 38px;
      font-weight: bold;
      text-align: center;
      line-height: 200px;
    }
    .input-item {
      display: block;
      width: 100%;
      margin-bottom: 20px;
      border: 0;
      padding: 10px;
      border-bottom: 1px solid rgb(128, 125, 125);
      font-size: 15px;
      outline: none;
    }
    .input-item::placeholder {
      text-transform: uppercase;
    }
    .btn {
      border: none;
      text-align: center;
      padding: 10px;
      width: 100%;
      margin-top: 40px;
      background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
      color: #fff;
    }
    .msg {
      text-align: center;
      line-height: 55px;
    }
    a {
      text-decoration-line: none;
      color: #abc1ee;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="login-wrapper">
    <div class="header">学生登录</div>
    <div class="form-wrapper">
      <form action="/LoginServlet" method="post">
      <input type="text" name="account" placeholder="username" class="input-item">
      <input type="password" name="password" placeholder="password" class="input-item">
      <input class="btn" type="submit" value="登 录">
      </form>
    </div>
    <div class="msg">
      Don't have account?
      <a href="/register.jsp">Sign up</a><br/>
      <a href="/adminlogin.jsp">管理员登录请点我</a><br/>
      <a href="/TeacherLogin.jsp">教师登录请点我</a>
    </div>
  </div>
</div>
</body>
</html>
