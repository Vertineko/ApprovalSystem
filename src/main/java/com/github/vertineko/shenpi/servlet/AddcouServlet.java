package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.Course;
import com.github.vertineko.shenpi.service.CourseService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddcouServlet", value = "/AddcouServlet")
public class AddcouServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var code = request.getParameter("code");
        var name = request.getParameter("name");
        var catalory = request.getParameter("catalory");
        var creadit = Integer.parseInt(request.getParameter("creadit"));
        Course course = new Course(code,name,catalory,creadit);
        CourseService.getCourseService().addCourse(course);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("<script language='javascript'>" +
                "alert('新增成功！');" +
                "window.location.href='adminmenu.jsp'</script>')");
    }
}
