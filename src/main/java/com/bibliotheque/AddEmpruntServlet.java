package com.bibliotheque;

import Models.Emprunt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AddEmpruntServlet")
public class AddEmpruntServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idAbonnee = Integer.parseInt(request.getParameter("idAbonnee"));
        int refOuvrage = Integer.parseInt(request.getParameter("refOuvrage"));
        String strDateEmprunt = request.getParameter("dateEmprunt");
        String strDateLimit = request.getParameter("dateLimit");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateEmprunt;
        Date dateLimit;
        try {
            dateEmprunt = dateFormat.parse(strDateEmprunt);
            dateLimit = dateFormat.parse(strDateLimit);
        } catch (ParseException e) {
            throw new ServletException("Error parsing date parameters", e);
        }

        Emprunt emprunt = new Emprunt();
        emprunt.setIdAbonnee(idAbonnee);
        emprunt.setRefOuvrage(refOuvrage);
        emprunt.setDateEmprunt(dateEmprunt);
        emprunt.setDateLimit(dateLimit);

        EmpruntDAO empruntDAO = new EmpruntDAO();
        empruntDAO.addEmprunt(emprunt);

        response.sendRedirect("dashboard.jsp");
    }
}