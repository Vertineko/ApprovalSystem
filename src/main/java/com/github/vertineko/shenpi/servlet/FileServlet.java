package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.Exfile;
import com.github.vertineko.shenpi.service.FileService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "FileServlet", value = "/FileServlet")
public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        var file = FileService.getFileService().getFile(id).getFile();
        if(file != null){
            response.setContentType(FileService.getFileService().getFile(id).getType());
            response.getOutputStream().write(file);
        }
    }
}
