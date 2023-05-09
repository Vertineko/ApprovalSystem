package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.github.vertineko.shenpi.model.User;
import java.io.IOException;

@WebServlet(name = "ModifystuServlet", value = "/ModifystuServlet")
public class ModifystuServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = Integer.parseInt(request.getParameter("id"));
        var name = request.getParameter("name");
        var telephone = request.getParameter("telephone");
        var account = request.getParameter("account");
        var password = request.getParameter("password");
        if(UserService.getUserService().findUserById(id) != null && UserService.getUserService().findUserByAccount(account) == null){
            User user = UserService.getUserService().findUserById(id);
            user.setName(name);
            user.setTelephone(telephone);
            user.setAccount(account);
            user.setPassword(password);
            UserService.getUserService().modifyUser(user);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('修改成功！');" +
                    "window.location.href='adminmenu.jsp';</script>')");
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('修改失败！该用户可能已不存在！');" +
                    "window.location.href='modifystu.jsp?id=" + id + "'</script>')");
        }

    }
}
