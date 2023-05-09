package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.Admin;
import com.github.vertineko.shenpi.service.AdminService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddadmServlet", value = "/AddadmServlet")
public class AddadmServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var username = request.getParameter("username");
        var password = request.getParameter("password");
        if(AdminService.getAdminService().getAdmin(username) != null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('新增失败，该账号已被注册！');" +
                    "window.location.href='Addadm.jsp'</script>')");
        }else {
            Admin admin = new Admin(username,password);
            AdminService.getAdminService().addAdmin(admin);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('新增成功！');" +
                    "window.location='adminmenu.jsp'</script>')");
        }
    }
}
