package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.Apply;
import com.github.vertineko.shenpi.model.Status;
import com.github.vertineko.shenpi.service.ApplyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ConfigureServlet", value = "/ConfigureServlet")
public class ConfigureServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = Integer.parseInt(request.getParameter("apply_id"));
        Apply apply = ApplyService.getApplyService().getApplyById(id);
        if(apply == null){
            response.getWriter().print("{\"flag\":false}");
        }else if(apply.getStatus().equals(Status.FAILED)){
            response.getWriter().print("{\"flag\":true}");
        }else if(apply.getStatus().equals(Status.PROCESSING_STAGE2)){
            apply.setStatus(Status.SUCCESS);
            ApplyService.getApplyService().updateApply(apply);
            response.getWriter().print("{\"flag\":true}");
        }
    }
}
