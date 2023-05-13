package com.github.vertineko.shenpi.servlet;

import com.github.vertineko.shenpi.model.Status;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("SearchResult.jsp").forward(request,response);
     }
}
