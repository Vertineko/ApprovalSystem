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
        HttpSession session = request.getSession();
        var account = request.getParameter("account");
        var password = request.getParameter("password");
        if(UserService.getUserService().loginService(account,password)){
            session.setAttribute("account",account);
            response.sendRedirect("/usermenu.jsp");
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('您输入的账号或密码错误，请重新输入！');" +
                    "window.location.href='login.jsp';</script>')");

        }
    }
}
