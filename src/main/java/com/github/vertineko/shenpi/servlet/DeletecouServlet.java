package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.service.CourseService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeletecouServlet", value = "/DeletecouServlet")
public class DeletecouServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = Integer.parseInt(request.getParameter("id"));
        if(CourseService.getCourseService().getCourseById(id) != null){
            CourseService.getCourseService().delete(id);
            response.getWriter().print("{\"flag\":true}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
