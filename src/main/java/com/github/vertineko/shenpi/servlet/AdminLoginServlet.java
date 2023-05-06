package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.Admin;
import com.github.vertineko.shenpi.service.AdminService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        var account = request.getParameter("account");
        var password = request.getParameter("password");
        if(AdminService.getAdminService().adminLogin(account,password)){
            session.setAttribute("account",account);
            request.getRequestDispatcher("adminmenu.jsp").forward(request,response);
        }else{
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('您输入的账号或密码错误，请重新输入！');" +
                    "window.location.href='adminlogin.jsp';</script>')");
        }
    }
}
