package com.bibliotheque;

import Dao.ConnectionDao;
import Models.Penalisation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SearchSanctionServlet")
public class SearchSanctionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int abonneeId = Integer.parseInt(request.getParameter("id_abonnee"));

        List<Penalisation> penalisations = searchPenalisations(abonneeId);

        sendResponse(response, penalisations);
    }

    private List<Penalisation> searchPenalisations(int abonneeId) {
        List<Penalisation> penalisationList = new ArrayList<>();

        String querySql = "SELECT sanction.id, sanction.id_abonnee, sanction.debutP, sanction.finP, utilisateur.nom, utilisateur.prenom " +
                "FROM sanction " +
                "JOIN utilisateur ON sanction.id_abonnee = utilisateur.id " +
                "WHERE sanction.id_abonnee = ?";

        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement statement = connection.prepareStatement(querySql)) {

            statement.setInt(1, abonneeId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Penalisation penalisation = new Penalisation();
                    penalisation.setId(resultSet.getInt("id"));
                    penalisation.setIdAbonnee(resultSet.getInt("id_abonnee"));
                    penalisation.setDebutP(String.valueOf(resultSet.getDate("debutP")));
                    penalisation.setFinP(String.valueOf(resultSet.getDate("finP")));

                    // Get abonnee's nom and prenom
                    penalisation.setNomAbonnee(resultSet.getString("nom"));
                    penalisation.setPrenomAbonnee(resultSet.getString("prenom"));

                    penalisationList.add(penalisation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return penalisationList;
    }

    private void sendResponse(HttpServletResponse response, List<Penalisation> penalisations) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Generate HTML dynamically based on the search results
            for (Penalisation penalisation : penalisations) {
                out.println("<tr class=\"border-b border-gray-200\">");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + penalisation.getId() + "</p>");
                out.println("</td>");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + penalisation.getNomAbonnee() + " " + penalisation.getPrenomAbonnee() + "</p>");
                out.println("</td>");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + penalisation.getDebutP() + "</p>");
                out.println("</td>");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + penalisation.getFinP() + "</p>");
                out.println("</td>");
                out.println("</tr>");
            }
        }
    }
}
