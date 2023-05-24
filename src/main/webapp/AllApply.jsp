<%@ page import="java.util.List" %>
<%@ page import="com.github.vertineko.shenpi.model.Apply" %>
<%@ page import="com.github.vertineko.shenpi.service.ApplyService" %>
<%@ page import="com.github.vertineko.shenpi.model.Course" %>
<%@ page import="com.github.vertineko.shenpi.service.CourseService" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/11
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审批记录</title>
    <script>
        const exportExcel = async() => {
            const res = await fetch("ExportServlet",{
                method:"get",
            })
            const response = await res.json()
            if(response.flag){
                let str = `课程id,备注（教师）,理由（学生）,学生id,主讲老师id,主管老师id,申请表序号,状态\n`;
                for(let i = 0;i < response.applies.length;i++){
                    for(let item in response.applies[i]){
                        <%--str+=`${response.applies[i][item] + '\t'},`--%>
                        str+= response.applies[i][item] + ",";
                    }
                    str+='\n';
                    console.log(str)
                }
                let uri = 'data:text/csv;charset=utf-8,\ufeff' + encodeURIComponent(str);
                var link = document.createElement("a");
                link.href = uri;
                link.download =  "审批表.csv";
                document.body.appendChild(link);
                link.click();
                document.body.removeChild(link);
            }else{
                alert("导出失败")
                return
            }
        }
    </script>
</head>
<body>
    <h1>审批记录</h1><hr/>
    <table>
        <th>审批流序号</th>
        <th>课程序号</th>
        <th>课程代码</th>
        <th>课程名称</th>
        <th>课程类别</th>
        <th>学分</th>
        <th>状态</th>

    <%
        List<Apply> applies = ApplyService.getApplyService().getAllApply();
        if(applies != null){
        for(Apply apply : applies){
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
<%--            <td><img src='"/FileServlet?id=" + <%=fileId%>' /></td>--%>
        </tr>

        <%
            }
            }

        %>

    </table><hr/>
    <input type="button" value="导出" onclick="exportExcel()">
</body>
</html>
