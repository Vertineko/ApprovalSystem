package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.Exfile;
import com.github.vertineko.shenpi.service.FileService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "UploadServlet", value = "/UploadServlet")
@MultipartConfig(maxFileSize = 16177215)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part idPart = request.getPart("apply_id");
        if(idPart != null){
            int apply_id = Integer.parseInt(new String(idPart.getInputStream().readAllBytes()));
            System.out.println(apply_id);
            System.out.println(idPart.getInputStream().readAllBytes().toString());
            InputStream inputStream = null;
            Part filePart = request.getPart("file");
            if(filePart != null){
                var type = filePart.getContentType();
                inputStream = filePart.getInputStream();
                byte[] bytes = inputStream.readAllBytes();
                Exfile file = new Exfile(apply_id,type,bytes);
                if(FileService.getFileService().getFile(apply_id) != null){
                    response.getWriter().print("{\"flag\":false}");
                }else {
                    FileService.getFileService().addFile(file);
                    response.getWriter().print("{\"flag\":true}");
                }


            }
        }




    }
}
