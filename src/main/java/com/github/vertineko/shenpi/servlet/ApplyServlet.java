package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.Apply;
import com.github.vertineko.shenpi.model.Status;
import com.github.vertineko.shenpi.service.ApplyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ApplyServlet", value = "/ApplyServlet")
public class ApplyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var course_id = Integer.parseInt(request.getParameter("course_id"));

        var user_id = Integer.parseInt(request.getParameter("user_id"));
        var reason = (String)request.getParameter("reason");
        if(ApplyService.getApplyService().getApply(course_id,user_id) != null){
            response.getWriter().print("{\"flag\":false}");
        }else {
            Apply apply_in = new Apply(course_id, Status.SUBMITTED,-1,-1,user_id,reason,"无");
            ApplyService.getApplyService().addApply(apply_in);
            Apply apply_out = ApplyService.getApplyService().getApply(course_id, user_id);
            int id = apply_out.getId();
            response.getWriter().print("{\"flag\":true,\"id\":"+ id +"}");
        }

    }
}
