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

@WebServlet("/SearchPenaliserServlet")
public class SearchPenaliserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String query = request.getParameter("query");
        String filter = request.getParameter("filter");


        List<Penalisation> penalisations = searchPenalisations(query);

        sendResponse(response, penalisations);
    }

    private List<Penalisation> searchPenalisations(String query) {
        List<Penalisation> penalisationList = new ArrayList<>();

        String querySql = "SELECT penaliser.*, utilisateur.nom, utilisateur.prenom " +
                "FROM penaliser " +
                "JOIN utilisateur ON penaliser.id_abonnee = utilisateur.id " +
                "WHERE utilisateur.nom LIKE ? OR utilisateur.prenom LIKE ?";

        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement statement = connection.prepareStatement(querySql)) {

            statement.setString(1, "%" + query + "%");
            statement.setString(2, "%" + query + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Penalisation penalisation = new Penalisation();
                    penalisation.setId(resultSet.getInt("id"));
                    penalisation.setIdAbonnee(resultSet.getInt("id_abonnee"));
                    penalisation.setNomAbonnee(resultSet.getString("nom"));
                    penalisation.setPrenomAbonnee(resultSet.getString("prenom"));
                    penalisation.setDebutP(String.valueOf(resultSet.getDate("debutP").toLocalDate()));
                    penalisation.setFinP(String.valueOf(resultSet.getDate("finP").toLocalDate()));

                    penalisationList.add(penalisation);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return penalisationList;
    }

    private void sendResponse(HttpServletResponse response, List<Penalisation> penalisations) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            for (Penalisation penalisation : penalisations) {
                out.println("<tr class=\"border-b border-gray-200\">");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + penalisation.getId() + "</p>");
                out.println("</td>");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + penalisation.getNomAbonnee() + "</p>");
                out.println("</td>");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + penalisation.getPrenomAbonnee() + "</p>");
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
