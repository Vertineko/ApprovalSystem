package com.github.vertineko.shenpi.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/usermenu.jsp")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if(req.getSession().getAttribute("account") != null){
            chain.doFilter(request, response);
        }else {
            req.getRequestDispatcher("loginerror.jsp").forward(req,res);
            return;
        }

    }
}
