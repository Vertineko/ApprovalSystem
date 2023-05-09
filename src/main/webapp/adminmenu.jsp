<%@ page import="java.util.List" %>
<%@ page import="com.github.vertineko.shenpi.model.User" %>
<%@ page import="com.github.vertineko.shenpi.service.UserService" %>
<%@ page import="com.github.vertineko.shenpi.model.Teacher" %>
<%@ page import="com.github.vertineko.shenpi.service.TeacherService" %>
<%@ page import="com.github.vertineko.shenpi.model.Course" %>
<%@ page import="com.github.vertineko.shenpi.service.CourseService" %>
<%@ page import="com.github.vertineko.shenpi.model.Admin" %>
<%@ page import="com.github.vertineko.shenpi.service.AdminService" %><%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/5/6
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
    <script type="text/javascript" src="js/adminmenu.js"></script>
</head>
<body>
    <h1>学生列表</h1><hr/>
    <table>
        <tr>
            <th>ID</th>
            <th>学生姓名</th>
            <th>联系电话</th>
            <th>账号</th>
            <th>密码</th>
            <th>操作</th>
            <th>操作</th>
            <th>操作</th>

        </tr>
        <form>
            <tr>
                <td><input type="text" name="id"></td>
                <td><input type="text" name="name"></td>
                <td><input type="text" name="telephone"></td>
                <td><input type="text" name="account"></td>
                <td><input type="text" name="password"></td>
                <td><input type="button" value="搜索"></td>
            </tr>
        </form>
        <%
            List<User> users = UserService.getUserService().getAllUser();
            if(users != null){
                for(User user : users){
        %>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getName()%></td>
            <td><%=user.getTelephone()%></td>
            <td><%=user.getAccount()%></td>
            <td><%=user.getPassword()%></td>
            <td><input type="button" value="修改" onclick="modify_stu(<%=user.getId()%>)"></td>
            <td><input type="button" value="删除" onclick="deletestu(<%=user.getId()%>)"></td>
            <td><input type="button" value="创建审批" onclick="create(<%=user.getId()%>)"></td>
        </tr>
        <%
                }
            }
        %>

    </table><hr/>
    <tr>
        <td><input type="button" value="新增" onclick="addstu()"></td>
    </tr><hr/>
    <h1>教师列表</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>教师姓名</th>
            <th>教授课程</th>
            <th>联系电话</th>
            <th>职务</th>
            <th>账号</th>
            <th>密码</th>
            <th>操作</th>
            <th></th>
        </tr>
        <form>
            <tr>
                <td><input type="text" name="id"></td>
                <td><input type="text" name="name"></td>
                <td><input type="text" name="coursename"></td>
                <td><input type="text" name="telephone"></td>
                <td><input type="text" name="role"></td>
                <td><input type="text" name="account"></td>
                <td><input type="text" name="password"></td>
                <td><input type="button" value="搜索"></td>

            </tr>
        </form>
        <%
            List<Teacher> teachers = TeacherService.getTeacherService().getAllTeacher();
            if(teachers != null){
                for (Teacher teacher : teachers){
                    Course course = CourseService.getCourseService().getCourseById(teacher.getCourse_id());
        %>
            <tr>
                <td><%=teacher.getId()%></td>
                <td><%=teacher.getName()%></td>
                <td><%=course.getName()%></td>
                <td><%=teacher.getTelephone()%></td>
                <td><%=teacher.getRole()%></td>
                <td><%=teacher.getAccount()%></td>
                <td><%=teacher.getPassword()%></td>
                <td><input type="button" value="修改" onclick="modify_tch(<%=teacher.getId()%>)"></td>
                <td><input type="button" value="删除" onclick="deletetch(<%=teacher.getId()%>)"></td>
            </tr>
        <%
                }
            }
        %>

    </table><hr/>
    <tr>
        <td><input type="button" value="新增" onclick="addtch()"></td>
    </tr><hr/>
    <h1>管理员列表</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th>操作</th>
            <th>操作</th>
        </tr>
        <form>
            <tr>
                <td><input type="text" name="id"></td>
                <td><input type="text" name="username"></td>
                <td><input type="text" name="password"></td>
                <td><input type="button" value="搜索"></td>
            </tr>
        </form>
        <%
            List<Admin> admins = AdminService.getAdminService().getAllAdmin();
            if(admins != null){
                for (Admin admin : admins){
        %>
            <tr>
                <td><%=admin.getId()%></td>
                <td><%=admin.getUsername()%></td>
                <td><%=admin.getPassword()%></td>
                <td><input type="button" value="修改" onclick="modify_adm(<%=admin.getId()%>)"></td>
                <td><input type="button" value="删除" onclick="deleteadm(<%=admin.getId()%>)"></td>
            </tr>
        <%
                }
            }
        %>

    </table><hr/>
    <tr>
        <td><input type="button" value="新增" onclick="addadm()"></td>
    </tr><hr/>
    <a href="" >查看所有审批</a>
</body>
</html>
