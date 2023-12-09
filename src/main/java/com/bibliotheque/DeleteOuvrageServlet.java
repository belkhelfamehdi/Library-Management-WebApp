// DeleteOuvrageServlet.java
// This is a basic example; adjust as per your project structure and requirements.

package com.bibliotheque;

import Models.Ouvrage;
import com.bibliotheque.OuvrageDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteOuvrageServlet")
public class DeleteOuvrageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ouvrageId = request.getParameter("id");

        OuvrageDAO ouvrageDAO = new OuvrageDAO();
        ouvrageDAO.deleteOuvrage(ouvrageId);

        response.sendRedirect("dashboard.jsp");
    }
}
