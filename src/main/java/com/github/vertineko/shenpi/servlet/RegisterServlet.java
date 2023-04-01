package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var name = request.getParameter("name");
        var telephone = request.getParameter("telephone");
        var account = request.getParameter("account");
        var password = request.getParameter("password");

        UserService.getUserService().regiseterService(name,telephone,account,password);
        response.sendRedirect("/login.jsp");
    }
}
