package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.Admin;
import com.github.vertineko.shenpi.service.AdminService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ModifyadmServlet", value = "/ModifyadmServlet")
public class ModifyadmServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = Integer.parseInt(request.getParameter("id"));
        var username = request.getParameter("username");
        var password = request.getParameter("password");
        if(AdminService.getAdminService().getAdmin(username) == null && AdminService.getAdminService().getAdminById(id) != null){
            Admin admin = AdminService.getAdminService().getAdminById(id);
            admin.setUsername(username);
            admin.setPassword(password);
            AdminService.getAdminService().modify(admin);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('修改成功！');" +
                    "window.location.href='adminmenu.jsp'</script>')");
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('修改失败,该用户名已存在');" +
                    "window.location.href='modifyadm.jsp?id=" + id + "'</script>')");
        }
    }
}
