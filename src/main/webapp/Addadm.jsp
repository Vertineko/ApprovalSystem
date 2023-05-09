<%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/9
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddAdmin</title>
</head>
<body>
    <h1>管理员新增</h1><hr/>
    <form action="AddadmServlet" method="post">
      用户名：<input type="text" name="username"><br/>
      密码：<input type="text" name="password"><br/>
      <input type="submit" value="提交">
    </form>

</body>
</html>
