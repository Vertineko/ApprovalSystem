<%@ page import="com.github.vertineko.shenpi.service.CourseService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.github.vertineko.shenpi.model.Course" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/3/31
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户界面</title>
    <link type="text/css" rel="stylesheet" href="css/usermenu.css">
    <script type="text/javascript" src="js/usermenu.js"></script>
</head>
<body>
    <h1>可选课程列表</h1><hr/>
    <table>
        <th>课程序号</th>
        <th>课程代码</th>
        <th>课程名称</th>
        <th>课程类别</th>
        <th>学分</th>
        <th>操作</th>
        <%
            if(CourseService.getCourseService() != null){
                List<Course> courses = CourseService.getCourseService().getAllCourse();
                for(Course course : courses){
        %>
        <tr>
            <td><%=course.getId()%></td>
            <td><%=course.getCode()%></td>
            <td><%=course.getName()%></td>
            <td><%=course.getCatalory()%></td>
            <td><%=course.getCreadit()%></td>
            <td><input type="button" value="申请" onclick="approve(<%=course.getId()%>)"></td>
        </tr>
        <%      }
            }
        %>
    </table><hr/>

</body>
</html>
