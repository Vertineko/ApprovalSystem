package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.service.TeacherService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "TeacherLoginServlet", value = "/TeacherLoginServlet")
public class TeacherLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        var account = request.getParameter("account");
        var password = request.getParameter("password");
        if(TeacherService.getTeacherService().TeacherLogin(account,password)){
            session.setAttribute("account",account);
            request.getRequestDispatcher("TeacherMenu.jsp").forward(request,response);
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('您输入的账号或密码错误，请重新输入！');" +
                    "window.location.href='TeacherLogin.jsp';</script>')");
        }
    }
}
