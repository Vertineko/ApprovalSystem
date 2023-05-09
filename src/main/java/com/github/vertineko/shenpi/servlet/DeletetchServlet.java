package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.service.TeacherService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeletetchServlet", value = "/DeletetchServlet")
public class DeletetchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = Integer.parseInt(request.getParameter("id"));
        if(TeacherService.getTeacherService().getTeacherById(id) == null){
            response.getWriter().print("{\"flag\":false}");
        }else {
            TeacherService.getTeacherService().deleteTeacher(id);
            response.getWriter().print("{\"flag\":true}");
        }
    }
}
