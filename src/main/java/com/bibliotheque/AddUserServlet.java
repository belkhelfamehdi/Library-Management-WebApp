package com.bibliotheque;

import Models.User;
import com.bibliotheque.UserDAO;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String dateNaissance = request.getParameter("dateNaissance");
        String role = "Abonnee";
        String statut = request.getParameter("statut");
        String type = request.getParameter("type");

        User user = new User();
        user.setLname(nom);
        user.setFname(prenom);
        user.setBirthDate(dateNaissance);
        user.setRole(role);
        user.setStatus(statut);
        user.setType(type);
        UserDAO userDAO = new UserDAO();
        userDAO.addUser(user);

        response.sendRedirect("dashboard.jsp");
    }
}
