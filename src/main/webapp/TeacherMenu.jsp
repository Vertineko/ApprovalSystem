<%@ page import="com.github.vertineko.shenpi.model.Apply" %>
<%@ page import="com.github.vertineko.shenpi.model.Course" %>
<%@ page import="com.github.vertineko.shenpi.service.CourseService" %>
<%@ page import="com.github.vertineko.shenpi.service.ApplyService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.github.vertineko.shenpi.service.TeacherService" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/6
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师界面</title>
    <link rel="stylesheet" type="text/css" href="css/TeacherMenu.css">
    <script type="text/javascript" src="js/TeacherMenu.js"></script>
</head>
<body>
    <h1>待审核表</h1>
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
            var teacher_id = TeacherService.getTeacherService().getTeacher(request.getSession().getAttribute("account").toString()).getId();
            List<Apply> selectedApply = ApplyService.getApplyService().getApplyofClass_s1();
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
            <td><input type="button" value="查看详情" onclick="dispatch(<%=teacher_id%>,<%=apply.getId()%>)"></td>
        </tr>

        <%
                }
            }

        %>

    </table><hr/>
</body>
</html>
