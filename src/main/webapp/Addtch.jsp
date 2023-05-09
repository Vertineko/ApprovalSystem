<%@ page import="com.github.vertineko.shenpi.model.Teacher" %>
<%@ page import="com.github.vertineko.shenpi.service.TeacherService" %>
<%@ page import="com.github.vertineko.shenpi.model.Course" %>
<%@ page import="com.github.vertineko.shenpi.service.CourseService" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/9
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddTeacher</title>
</head>
<body>
    <h1>教师新增</h1><hr/>
    <%
      List<Course> courses = CourseService.getCourseService().getAllCourse();
    %>

    <form action="AddtchServlet" method="post">
      <input type="hidden"  name="id">
      姓名：<input type="text" name="name" ><br/>
      电话：<input type="text" name="telephone" ><br/>
      职务：<input type="radio" value="SPEECHER" name="role" checked>主讲教师
      <input type="radio" value="MANAGE" name="role">主管教师<br/>
      教授课程：<select name="course">
      <%
        if(courses != null){
          for (Course course : courses){

      %>
      <option value="<%=course.getId()%>"><%=course.getName()%></option>
      <%
          }
        }
      %>
    </select><br/>
      账号：<input type="text" name="account" ><br/>
      密码：<input type="text" name="password" ><br/>
      <input type="submit" value="提交修改">
    </form>
</body>
</html>
