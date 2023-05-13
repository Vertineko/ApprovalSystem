package com.github.vertineko.shenpi.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SearchServlet2", value = "/SearchServlet2")
public class SearchServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("SearchResult2.jsp").forward(request,response);
    }
}
