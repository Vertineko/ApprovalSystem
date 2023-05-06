<%@ page import="com.github.vertineko.shenpi.service.CourseService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.github.vertineko.shenpi.model.Course" %>
<%@ page import="com.github.vertineko.shenpi.model.Apply" %>
<%@ page import="com.github.vertineko.shenpi.service.ApplyService" %>
<%@ page import="com.github.vertineko.shenpi.service.UserService" %><%--
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
            var user_id = UserService.getUserService().findUserByAccount(request.getSession().getAttribute("account").toString()).getId();
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
            <td><input type="button" value="申请" onclick="approve(<%=course.getId()%>)"></td>
        </tr>
        <%      }
            }
        %>
    </table><hr/>
    <h1>已申请课程列表</h1><hr/>
    <table>
        <th>审批流序号</th>
        <th>课程序号</th>
        <th>课程代码</th>
        <th>课程名称</th>
        <th>课程类别</th>
        <th>学分</th>
        <th>状态</th>
        <th>操作</th>
        <%
            List<Apply> selectedApply = ApplyService.getApplyService().getSelectedApply(user_id);
            if(selectedApply != null){
            for(Apply apply : selectedApply){
                Course course = CourseService.getCourseService().getCourseById(apply.getCourse_id());

        %>
            <tr>
                <td><%=apply.getId()%></td>
                <td><%=course.getId()%></td>
                <td><%=course.getCode()%></td>
                <td><%=course.getName()%></td>
                <td><%=course.getCatalory()%></td>
                <td><%=course.getCreadit()%></td>
                <td><%=apply.getStatus()%></td>
                <td><input type="button" value="查看详情" onclick="check(<%=apply.getId()%>)"></td>
            </tr>

        <%
                }
            }
        %>

    </table><hr/>
    <input class="btncenter" type="button" value="查看所有已申请记录" >
</body>
</html>
