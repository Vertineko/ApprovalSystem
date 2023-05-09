<%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/9
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddCourse</title>
</head>
<body>
<h1>课程信息新增</h1><hr/>
<form action="AddcouServlet" method="post">

  课程代码：<input type="text" name="code"><br/>
  课程名：<input type="text" name="name" ><br/>
  课程类别：<input type="text" name="catalory" ><br/>
  学分：<input type="text" name="creadit" ><br/>
  <input type="submit" value="提交">
</form>
</body>
</html>
