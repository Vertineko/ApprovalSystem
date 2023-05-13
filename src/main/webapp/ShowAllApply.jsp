<%@ page import="java.util.List" %>
<%@ page import="com.github.vertineko.shenpi.model.Apply" %>
<%@ page import="com.github.vertineko.shenpi.service.ApplyService" %>
<%@ page import="com.github.vertineko.shenpi.model.Course" %>
<%@ page import="com.github.vertineko.shenpi.service.CourseService" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/13
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有申请记录</title>
    <script>
        function BeforePage(pageNow,user_id){
            if(pageNow == 1){
                alert("当前已无上一页！")
                return
            }else {
                const page = pageNow - 1;
                const desturl = "ShowAllApply.jsp?" + "user_id=" + user_id + "&" + "page=" + page
                window.location.href = desturl
            }
        }
        function NextPage(pageNow,user_id,count){
            if(pageNow > count){
                pageNow = count
            }else {
                if(pageNow + 1 > count){
                    alert("当前已无下一页！")
                }else {
                    const page = pageNow + 1;
                    const desturl = "ShowAllApply.jsp?" + "user_id=" + user_id  + "&" + "page=" + page
                    window.location.href = desturl
                }
            }
        }
    </script>
</head>
<body>
    <%
        var user_id = Integer.parseInt(request.getParameter("user_id"));
    %>
    <h1>所有审批记录</h1>
    <table>
        <tr>
            <th>审批流序号</th>
            <th>课程序号</th>
            <th>课程代码</th>
            <th>课程名称</th>
            <th>课程类别</th>
            <th>学分</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <tr>
            <form action="SearchServlet" method="post">
                <input type="hidden" name="user_id" value="<%=user_id%>">
                <td><input type="text" name="apply_id"></td>
                <td><input type="text" name="course_id"></td>
                <td><input type="text" name="code"></td>
                <td><input type="text" name="name"></td>
                <td><input type="text" name="catalory"></td>
                <td><input type="text" name="creadit"></td>
                <td><input type="text" name="status"></td>
                <td><input type="submit" value="搜索"></td>
            </form>
        </tr>


    <%
        var id = Integer.parseInt(request.getParameter("user_id"));
        int pageCount = 3;
        int count = ApplyService.getApplyService().getCountSelectedApply(id)/pageCount + 1;
        var pageNow = Integer.parseInt(request.getParameter("page"));
        int pageNum = pageCount * (pageNow-1);
        List<Apply> applies = ApplyService.getApplyService().getAllSelectedApply(id,pageNum,pageCount);
        if(applies != null){
            for (Apply apply:applies){
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
    <input type="button" value="上一页" onclick="BeforePage(<%=pageNow%>,<%=id%>)">&nbsp;&nbsp;
    当前<%=pageNow%>/共<%=count%>页&nbsp;&nbsp;
    <input type="button" value="下一页"  onclick="NextPage(<%=pageNow%>,<%=id%>,<%=count%>)">
</body>
</html>
