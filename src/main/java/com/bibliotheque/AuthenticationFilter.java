package com.bibliotheque;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/dashboard.jsp")
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // Initialization if needed
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = session != null && session.getAttribute("username") != null;

        if (isLoggedIn) {
            chain.doFilter(request, response); // Continue to the requested resource
        } else {
            httpResponse.sendRedirect("index.jsp"); // Redirect unauthenticated users to the login page
        }
    }

    public void destroy() {
        // Cleanup if needed
    }
}
