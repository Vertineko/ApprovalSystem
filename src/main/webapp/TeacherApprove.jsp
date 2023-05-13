<%@ page import="com.github.vertineko.shenpi.model.*" %>
<%@ page import="com.github.vertineko.shenpi.service.*" %>
<%@ page import="java.io.OutputStream" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/6
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>申请表详情</title>
    <link type="text/css" rel="stylesheet" href="css/TeacherApprove.css">
    <script type="text/javascript" src="js/TeacherApprove.js"></script>
</head>
<body>
    <%
        var teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
        var apply_id = Integer.parseInt(request.getParameter("apply_id"));
        Apply apply = ApplyService.getApplyService().getApplyById(apply_id);
        Teacher teacher = TeacherService.getTeacherService().getTeacherById(teacher_id);
        String role = teacher.getRole().name();

        Course course = CourseService.getCourseService().getCourseById(apply.getCourse_id());
        User user = UserService.getUserService().findUserById(apply.getUser_id());
        Exfile file = FileService.getFileService().getFile(apply_id);
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
    证明文件：<img src="FileServlet?id=<%=apply_id%>" />
</fieldset>
    备注：<textarea id="note" type="textarea" placeholder="若驳回申请，请填入理由" rols="5" cols="50"></textarea><br/>
<input type="button" value="同意" onclick="approve(1,<%=teacher_id%>,<%=apply_id%>,'<%=role%>')">
<input type="button" value="驳回" onclick="approve(0,<%=teacher_id%>,<%=apply_id%>,'<%=role%>')">
</body>
</html>
