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
    <title>学生信息修改页面</title>
</head>
<body>
    <%
        var id = Integer.parseInt(request.getParameter("id"));
        User user = UserService.getUserService().findUserById(id);
    %>
    <h1>学生信息修改</h1>
    <form action="ModifystuServlet" method="post">
        <input name="id" value="<%=user.getId()%>" type="hidden">
        姓名：<input type="text" name="name" value="<%=user.getName()%>"><br/>
        电话：<input type="text" name="telephone" value="<%=user.getTelephone()%>"><br/>
        账号：<input type="text" name="account" value="<%=user.getAccount()%>"><br/>
        密码：<input type="text" name="password" value="<%=user.getPassword()%>"><br/>
        <input type="submit" value="提交修改">
    </form>
</body>
</html>
