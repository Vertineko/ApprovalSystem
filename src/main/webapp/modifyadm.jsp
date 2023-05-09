<%@ page import="com.github.vertineko.shenpi.model.Admin" %>
<%@ page import="com.github.vertineko.shenpi.service.AdminService" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/9
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员信息修改页面</title>
</head>
<body>
    <%
        var id = Integer.parseInt(request.getParameter("id"));
        Admin admin = AdminService.getAdminService().getAdminById(id);
    %>
    <h1>管理员信息修改</h1><hr/>
    <form action="ModifyadmServlet" method="post">
        <input type="hidden" name="id" value="<%=admin.getId()%>">
        用户名：<input type="text" name="username" value="<%=admin.getUsername()%>"><br/>
        密码：<input type="text" name="password" value="<%=admin.getPassword()%>"><br/>
        <input type="submit" value="提交修改">
    </form>
</body>
</html>
