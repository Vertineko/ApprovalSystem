package com.github.vertineko.shenpi.filter;

import com.github.vertineko.shenpi.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "RoleFilter",urlPatterns = "/usermenu.jsp")
public class UserFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if(UserService.getUserService().findUserByAccount(req.getSession().getAttribute("account").toString()) != null){
            chain.doFilter(request, response);
        }else{
            req.getRequestDispatcher("UserRoleError.jsp").forward(req,res);
            return;
        }

    }
}
