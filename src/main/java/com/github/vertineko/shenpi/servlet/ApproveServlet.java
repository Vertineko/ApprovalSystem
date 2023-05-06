package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.Apply;
import com.github.vertineko.shenpi.model.Status;
import com.github.vertineko.shenpi.service.AdminService;
import com.github.vertineko.shenpi.service.ApplyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ApproveServlet", value = "/ApproveServlet")
public class ApproveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var pass = Integer.parseInt(request.getParameter("pass"));
        var teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
        var apply_id = Integer.parseInt(request.getParameter("apply_id"));
        var role = request.getParameter("role");
        var note = request.getParameter("note");
        Apply apply = ApplyService.getApplyService().getApplyById(apply_id);
        if(role.equals("SPEECHER")){
            if(pass == 1){
                apply.setNote(note);
                apply.setTeacher1_id(teacher_id);
                apply.setStatus(Status.PROCESSING_STAGE1);
                ApplyService.getApplyService().updateApply(apply);
                response.getWriter().print("{\"flag\":true}");
            }else {
                apply.setNote(note);
                apply.setTeacher1_id(teacher_id);
                apply.setStatus(Status.FAILED);
                ApplyService.getApplyService().updateApply(apply);
                response.getWriter().print("{\"flag\":true}");
            }
        } else if (role.equals("MANAGE")) {
            if(pass == 1){
                apply.setNote(note);
                apply.setTeacher2_id(teacher_id);
                apply.setStatus(Status.PROCESSING_STAGE2);
                ApplyService.getApplyService().updateApply(apply);
                response.getWriter().print("{\"flag\":true}");
            }else {
                apply.setNote(note);
                apply.setTeacher2_id(teacher_id);
                apply.setStatus(Status.FAILED);
                ApplyService.getApplyService().updateApply(apply);
                response.getWriter().print("{\"flag\":true}");
            }
        }
    }
}
