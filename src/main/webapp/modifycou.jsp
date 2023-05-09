<%@ page import="com.github.vertineko.shenpi.model.Course" %>
<%@ page import="com.github.vertineko.shenpi.service.CourseService" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/9
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ModifyCourse</title>
</head>
<body>
    <%
      var id = Integer.parseInt(request.getParameter("id"));
      Course course = CourseService.getCourseService().getCourseById(id);
    %>
    <h1>课程信息修改</h1><hr/>
    <form action="ModifycouServlet" method="post">
      <input type="hidden" name="id" value="<%=course.getId()%>">
      课程代码：<input type="text" name="code" value="<%=course.getCode()%>"><br/>
      课程名：<input type="text" name="name" value="<%=course.getName()%>"><br/>
      课程类别：<input type="text" name="catalory" value="<%=course.getCatalory()%>"><br/>
      学分：<input type="text" name="creadit" value="<%=course.getCreadit()%>"><br/>
      <input type="submit" value="提交修改">
    </form>
</body>
</html>
