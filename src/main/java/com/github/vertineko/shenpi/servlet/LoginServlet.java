package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import com.github.vertineko.shenpi.service.UserService;
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var username = request.getParameter("account");
        var password = request.getParameter("password");
        if(UserService.getUserService().loginService(username,password)){
            response.sendRedirect("/usermenu.jsp");
        }else {
            response.sendRedirect("/login.jsp");
        }
    }
}
