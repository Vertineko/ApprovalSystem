<%@ page import="com.github.vertineko.shenpi.dao.TeacherDao" %>
<%@ page import="com.github.vertineko.shenpi.service.TeacherService" %>
<%@ page import="com.github.vertineko.shenpi.model.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page import="com.github.vertineko.shenpi.model.Course" %>
<%@ page import="com.github.vertineko.shenpi.service.CourseService" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/9
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息修改页面</title>
</head>

<body>
    <%
        var id = Integer.parseInt(request.getParameter("id"));
        Teacher teacher = TeacherService.getTeacherService().getTeacherById(id);
        List<Course> courses = CourseService.getCourseService().getAllCourse();
    %>
    <h1>教师信息修改</h1><hr/>
    <form action="ModifytchServlet" method="post">
        <input type="hidden" value="<%=id%>" name="id">
        姓名：<input type="text" name="name" value="<%=teacher.getName()%>"><br/>
        电话：<input type="text" name="telephone" value="<%=teacher.getTelephone()%>"><br/>
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
        账号：<input type="text" name="account" value="<%=teacher.getAccount()%>"><br/>
        密码：<input type="text" name="password" value="<%=teacher.getPassword()%>"><br/>
        <input type="submit" value="提交修改">
    </form>
</body>
</html>
