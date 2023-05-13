<%@ page import="com.github.vertineko.shenpi.model.Status" %>
<%@ page import="com.github.vertineko.shenpi.service.AdminService" %>
<%@ page import="com.github.vertineko.shenpi.service.ApplyService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.github.vertineko.shenpi.model.Apply" %>
<%@ page import="com.github.vertineko.shenpi.service.CourseService" %>
<%@ page import="com.github.vertineko.shenpi.model.Course" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/13
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
<h1>查询结果</h1>
<table>
  <tr>
    <th>审批流序号</th>
    <th>课程序号</th>
    <th>课程代码</th>
    <th>课程名称</th>
    <th>课程类别</th>
    <th>学分</th>
    <th>状态</th>
  </tr>
    <%
      var user_id = request.getParameter("user_id");
      var apply_id = request.getParameter("apply_id");
      var course_id = request.getParameter("course_id");
      var code = request.getParameter("code");
      var name = request.getParameter("name");
      var catalory = request.getParameter("catalory");
      var creadit = request.getParameter("creadit");
      var status = request.getParameter("status");

      List<Apply> applies = ApplyService.getApplyService().searchApply(user_id,apply_id,course_id,code,name,catalory,creadit,status);

      if(applies != null){
        System.out.println("有");
        for (Apply apply : applies){
          System.out.println(apply.getId());
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
  </tr>
    <%
        }
      }
    %>
</table><hr/>
</body>
</html>
