package com.bibliotheque;

import Models.Ouvrage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateOuvrageServlet")
public class UpdateOuvrageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int ref = Integer.parseInt(request.getParameter("ref"));
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String rayon = request.getParameter("rayon");
        int disponibilite = Integer.parseInt(request.getParameter("disponibilite"));

        Ouvrage ouvrage = new Ouvrage();
        ouvrage.setRef(ref);
        ouvrage.setTitre(titre);
        ouvrage.setAuteur(auteur);
        ouvrage.setRayon(rayon);
        ouvrage.setDisponibilite(disponibilite);

        OuvrageDAO ouvrageDAO = new OuvrageDAO();
        ouvrageDAO.updateOuvrage(ouvrage);

        response.sendRedirect("dashboard.jsp");
    }
}
