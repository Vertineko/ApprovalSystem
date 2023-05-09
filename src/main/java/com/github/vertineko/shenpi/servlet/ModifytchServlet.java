package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.Role;
import com.github.vertineko.shenpi.model.Teacher;
import com.github.vertineko.shenpi.service.TeacherService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ModifytchServlet", value = "/ModifytchServlet")
public class ModifytchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = Integer.parseInt(request.getParameter("id"));
        var temp = request.getParameter("role");
        var role = Role.MANAGE;
        for(Role role1 : Role.values()){
            if(role1.toString().equals(temp)){
                role = role1;
            }
        }
        var account = request.getParameter("account");
        //System.out.println(role);
        if(TeacherService.getTeacherService().getTeacherById(id) != null && TeacherService.getTeacherService().getTeacher(account) == null){
            var name = request.getParameter("name");
            var telephone = request.getParameter("telephone");
            var course_id = Integer.parseInt(request.getParameter("course"));

            var password = request.getParameter("password");
            Teacher teacher = TeacherService.getTeacherService().getTeacherById(id);
            teacher.setName(name);
            teacher.setTelephone(telephone);
            teacher.setRole(role);
            teacher.setCourse_id(course_id);
            teacher.setAccount(account);
            teacher.setPassword(password);
            TeacherService.getTeacherService().updateTeacher(teacher);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('修改成功！');" +
                    "window.location.href='adminmenu.jsp';</script>')");
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('修改失败！该用户可能已不存在！');" +
                    "window.location.href='modifytch.jsp?id=" + id + "'</script>')");
        }

    }
}
