package com.github.vertineko.shenpi.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.vertineko.shenpi.model.Apply;
import com.github.vertineko.shenpi.service.ApplyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExportServlet", value = "/ExportServlet")
public class ExportServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Apply> applies = ApplyService.getApplyService().getAllApply();
        if(applies != null){
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(applies);
            response.getWriter().print("{\"flag\":true,\"applies\":" + jsonObject + "}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Apply> applies =  ApplyService.getApplyService().getAllApply();
        if(applies != null){
            JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(applies));
            response.getWriter().print("{\"flag\":true,\"applies\":" + jsonArray + "}");
        }else {
            response.getWriter().print("{\"flag\":false}");
        }
    }
}
