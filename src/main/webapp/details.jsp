<%@ page import="com.github.vertineko.shenpi.model.Apply" %>
<%@ page import="com.github.vertineko.shenpi.service.ApplyService" %>
<%@ page import="com.github.vertineko.shenpi.model.User" %>
<%@ page import="com.github.vertineko.shenpi.service.UserService" %>
<%@ page import="com.github.vertineko.shenpi.model.Course" %>
<%@ page import="com.github.vertineko.shenpi.service.CourseService" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/6
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详请界面</title>
    <link rel="stylesheet" type="text/css" href="css/details.css">
    <script type="text/javascript" src="js/details.js"></script>
</head>
<body>
    <%
        var apply_id = Integer.parseInt(request.getParameter("apply_id").toString());
        Apply apply = ApplyService.getApplyService().getApplyById(apply_id);
        User user = UserService.getUserService().findUserById(apply.getUser_id());
        Course course = CourseService.getCourseService().getCourseById(apply.getCourse_id());
    %>
    <fieldset>
        课程序号：<%=course.getId()%><br/>
        课程代码：<%=course.getCode()%><br/>
        课程名称：<%=course.getName()%><br/>
        课程分类：<%=course.getCatalory()%><br/>
        课程学分：<%=course.getCreadit()%><br/>
    </fieldset>
    <fieldset>
        申请人ID：<%=user.getId()%><br/>
        申请人姓名：<%=user.getName()%><br/>
        联系电话：<%=user.getTelephone()%><br/>
        申请人账号：<%=user.getAccount()%><br/>
    </fieldset>
    <fieldset>
        申请理由：<%=apply.getReason()%><br/>
        证明文件：<img src="FileServlet?id=<%=apply_id%>"/><br/>
        教师留言：<%=apply.getNote()%>
    </fieldset>
    <fieldset>
        当前状态：<%=apply.getStatus()%>
    </fieldset>
    <input type="button" value="确认" onclick="configure(<%=apply_id%>,'<%=apply.getStatus()%>')">
    <input type="button" value="返回" onclick="back()">
</body>
</html>
