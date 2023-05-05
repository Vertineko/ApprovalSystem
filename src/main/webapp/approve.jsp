<%@ page import="com.github.vertineko.shenpi.service.CourseService" %>
<%@ page import="com.github.vertineko.shenpi.model.Course" %>
<%@ page import="com.github.vertineko.shenpi.model.User" %>
<%@ page import="com.github.vertineko.shenpi.service.UserService" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/4
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>申请表单</title>
    <link type="text/css" rel="stylesheet" href="css/approve.css">
    <script type="text/javascript" src="js/approve.js"></script>
</head>
<body>
    <h1>申请表</h1>
    <%
        var account_obj = request.getSession().getAttribute("account");
        var account_str = (String)account_obj;
        User user = UserService.getUserService().findUserByAccount(account_str);
        var id_str = request.getParameter("course_id");
        int id = Integer.parseInt(id_str);
        Course course = CourseService.getCourseService().getCourseById(id);
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
        申请理由：<input type="text" id="reason"><br/>
        证明文件：<input type="file">
    </fieldset>
    <input type="button" value="提交" onclick="approve(<%=course.getId()%>,<%=user.getId()%>)">
</body>
</html>
