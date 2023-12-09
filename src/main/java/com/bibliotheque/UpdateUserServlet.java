package com.bibliotheque;

import Models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userId = request.getParameter("userId");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String birthDate = request.getParameter("birthDate");
        String status = request.getParameter("status");
        String role = request.getParameter("role");
        String type = request.getParameter("type");

        User user = new User();
        user.setId(Integer.parseInt(userId));
        user.setFname(fname);
        user.setLname(lname);
        user.setBirthDate(birthDate);
        user.setStatus(status);
        user.setRole(role);
        user.setType(type);

        UserDAO userDAO = new UserDAO();
        userDAO.updateUser(user);

        response.sendRedirect("dashboard.jsp");
    }
}
