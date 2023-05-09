package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.User;
import com.github.vertineko.shenpi.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddstuServlet", value = "/AddstuServlet")
public class AddstuServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var name = request.getParameter("name");
        var telephone = request.getParameter("telephone");
        var account = request.getParameter("account");
        var password = request.getParameter("password");
        if(UserService.getUserService().findUserByAccount(account) != null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('新增失败，该账号已被注册！');" +
                    "window.location.href='Addstu.jsp'</script>')");
        }else {
            User user = new User(name,telephone,account,password);
            UserService.getUserService().regiseterService(name,telephone,account,password);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('新增成功！');" +
                    "window.location='adminmenu.jsp'</script>')");
        }
    }
}
