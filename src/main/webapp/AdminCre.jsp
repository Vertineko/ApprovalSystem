<%@ page import="com.github.vertineko.shenpi.service.UserService" %>
<%@ page import="com.github.vertineko.shenpi.service.CourseService" %>
<%@ page import="com.github.vertineko.shenpi.model.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/9
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建审批流</title>
    <script type="text/javascript" src="js/AdminCre.js"></script>
</head>
<body>
    <h1>创建审批</h1>
    <%
      var user_id = Integer.parseInt(request.getParameter("id"));
    %>

    <table>
      <th>课程序号</th>
      <th>课程代码</th>
      <th>课程名称</th>
      <th>课程类别</th>
      <th>学分</th>
      <th>操作</th>
        <%

            if(CourseService.getCourseService().getAllCourse() != null){
                List<Course> courses = CourseService.getCourseService().getAllCourse();
                for(Course course : courses){
        %>
      <tr>
        <td><%=course.getId()%></td>
        <td><%=course.getCode()%></td>
        <td><%=course.getName()%></td>
        <td><%=course.getCatalory()%></td>
        <td><%=course.getCreadit()%></td>
        <td><input type="button" value="申请" onclick="approve(<%=course.getId()%>,<%=user_id%>)"></td>
      </tr>
        <%      }
            }
        %>
</body>
</html>
