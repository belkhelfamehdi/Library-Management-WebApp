package com.bibliotheque;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/dashboard.jsp"})
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = session != null && session.getAttribute("username") != null;

        if (isLoggedIn) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect("index.jsp");
        }
    }
    public void destroy() {
    }
}
