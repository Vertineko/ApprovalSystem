package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeletestuServlet", value = "/DeletestuServlet")
public class DeletestuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = Integer.parseInt(request.getParameter("id"));
        if(UserService.getUserService().findUserById(id) != null){
            UserService.getUserService().deleteUser(id);
            response.getWriter().print("{\"flag\":true}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
