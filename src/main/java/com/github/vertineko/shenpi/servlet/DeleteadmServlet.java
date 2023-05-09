package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.service.AdminService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteadmServlet", value = "/DeleteadmServlet")
public class DeleteadmServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = Integer.parseInt(request.getParameter("id"));
        if(AdminService.getAdminService().getAdminById(id) != null){
            AdminService.getAdminService().delete(id);
            response.getWriter().print("{\"flag\":true}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
