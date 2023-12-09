package com.bibliotheque;

import Models.Emprunt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.time.LocalDate;

@WebServlet("/EmpruntServlet")
public class EmpruntServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] selectedUserIds = request.getParameterValues("selectedUsers");
        String[] selectedOuvrageRefs = request.getParameterValues("selectedOuvrages");

        EmpruntDAO empruntDAO = new EmpruntDAO();

        for (String userId : selectedUserIds) {
            String[] userIds = userId.split(",");
            for (String singleUserId : userIds) {
                int userIdInt = Integer.parseInt(singleUserId);

                // Check if the user already has less than three ouvrages
                int userEmprunts = empruntDAO.getEmpruntByUserId(userIdInt);
                if (userEmprunts >= 3) {
                    // Redirect to the referer with an error message
                    request.setAttribute("errorMessage", "Limit exceeded: Users can have at most 3 emprunts.");
                    response.sendRedirect(request.getHeader("referer") + "?error=limit_exceeded");
                    return;
                }

                for (String ouvrageRef : selectedOuvrageRefs) {
                    String[] ouvrageRefs = ouvrageRef.split(",");
                    for (String singleOuvrageRef : ouvrageRefs) {
                        int ouvrageRefInt = Integer.parseInt(singleOuvrageRef);

                        // Add emprunt for the current user and ouvrage
                        Emprunt emprunt = new Emprunt();
                        emprunt.setIdAbonnee(userIdInt);
                        emprunt.setRefOuvrage(ouvrageRefInt);

                        // Set dateEmprunt to today
                        emprunt.setDateEmprunt(java.sql.Date.valueOf(LocalDate.now()));

                        // Set dateLimit to today + 15 days
                        LocalDate dateLimit = LocalDate.now().plusDays(15);
                        emprunt.setDateLimit(java.sql.Date.valueOf(dateLimit));

                        empruntDAO.addEmprunt(emprunt);
                    }
                }
            }
        }

        response.sendRedirect(request.getHeader("referer"));
    }
}