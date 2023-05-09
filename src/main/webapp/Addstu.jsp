<%@ page import="com.github.vertineko.shenpi.model.User" %>
<%@ page import="com.github.vertineko.shenpi.service.UserService" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/9
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息新增页面</title>
</head>
<body>

    <h1>学生信息新增</h1>
    <form action="AddstuServlet" method="post">
        姓名：<input type="text" name="name" ><br/>
        电话：<input type="text" name="telephone" ><br/>
        账号：<input type="text" name="account"><br/>
        密码：<input type="text" name="password"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
