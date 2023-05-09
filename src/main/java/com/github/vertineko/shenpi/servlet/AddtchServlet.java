package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.Role;
import com.github.vertineko.shenpi.model.Teacher;
import com.github.vertineko.shenpi.service.TeacherService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddtchServlet", value = "/AddtchServlet")
public class AddtchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var name = request.getParameter("name");
        var telephone = request.getParameter("telephone");
        var course_id = Integer.parseInt(request.getParameter("course"));
        var account = request.getParameter("account");
        var password = request.getParameter("password");
        var temp = request.getParameter("role");
        var role = Role.MANAGE;
        for(Role role1 : Role.values()){
            if(role1.toString().equals(temp)){
                role = role1;
            }
        }
        if(TeacherService.getTeacherService().getTeacher(account) != null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('该账号已被注册！');" +
                    "window.location.href='Addtch.jsp';</script>')");
        }else {
            Teacher teacher = new Teacher(account,password,name,telephone,role,course_id);
            TeacherService.getTeacherService().addTeacher(teacher);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('新增成功！');" +
                    "window.location.href='adminmenu.jsp';</script>')");
        }
    }
}
