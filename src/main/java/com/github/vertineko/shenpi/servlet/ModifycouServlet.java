package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.Course;
import com.github.vertineko.shenpi.service.CourseService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ModifycouServlet", value = "/ModifycouServlet")
public class ModifycouServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = Integer.parseInt(request.getParameter("id"));
        var code = request.getParameter("code");
        var name = request.getParameter("name");
        var catalory = request.getParameter("catalory");
        var creadit = Integer.parseInt(request.getParameter("creadit"));
        if(CourseService.getCourseService().getCourseById(id) != null){
            Course course = CourseService.getCourseService().getCourseById(id);
            course.setCode(code);
            course.setName(name);
            course.setCatalory(catalory);
            course.setCreadit(creadit);
            CourseService.getCourseService().modify(course);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('修改成功');" +
                    "window.location.href='adminmenu.jsp'</script>')");
        }else{
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('修改失败,该课程已存在');" +
                    "window.location.href='modifycou.jsp?id=" + id + "'</script>')");
        }
    }
}
