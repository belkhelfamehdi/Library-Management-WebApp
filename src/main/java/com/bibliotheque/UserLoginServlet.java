package com.bibliotheque;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.isEmpty() || password.isEmpty()) {
            response.sendRedirect("index.jsp?error=empty");
        } else {
            String userType = UserDAO.checkLogin(username, password);

            if (userType != null) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("userType", userType);

                if (userType.equals("Abonnee")) {
                    response.sendRedirect("dashboard.jsp");
                } else if (userType.equals("Gestionnaire")) {
                    response.sendRedirect("dashboard.jsp");
                } else if (userType.equals("Bibliothecaire")) {
                    response.sendRedirect("dashboard.jsp");
                }
            } else {
                response.sendRedirect("index.jsp?error=invalid");
            }
        }
    }
}
