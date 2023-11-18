package com.bibliotheque;

import Dao.ConnectionDao;
import Models.Ouvrage;

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

@WebServlet("/SearchOuvrageServlet")
public class SearchOuvrageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String query = request.getParameter("query");

        List<Ouvrage> ouvrages = searchOuvrages(query);

        sendResponse(response, ouvrages);
    }

    private List<Ouvrage> searchOuvrages(String query) {
        List<Ouvrage> ouvrageList = new ArrayList<>();

        String querySql = "SELECT * FROM ouvrages WHERE titre LIKE ? OR auteur LIKE ?";

        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement statement = connection.prepareStatement(querySql)) {

            statement.setString(1, "%" + query + "%");
            statement.setString(2, "%" + query + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Ouvrage ouvrage = new Ouvrage();
                    ouvrage.setRef(resultSet.getInt("Ref"));
                    ouvrage.setTitre(resultSet.getString("titre"));
                    ouvrage.setAuteur(resultSet.getString("auteur"));
                    ouvrage.setRayon(resultSet.getString("rayon"));
                    ouvrage.setDisponibilite(resultSet.getInt("Disponibilite"));

                    ouvrageList.add(ouvrage);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ouvrageList;
    }

    private void sendResponse(HttpServletResponse response, List<Ouvrage> ouvrages) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Generate HTML dynamically based on the search results
            for (Ouvrage ouvrage : ouvrages) {
                out.println("<tr class=\"border-b border-gray-200\">");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + ouvrage.getRef() + "</p>");
                out.println("</td>");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + ouvrage.getTitre() + "</p>");
                out.println("</td>");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + ouvrage.getAuteur() + "</p>");
                out.println("</td>");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + ouvrage.getRayon() + "</p>");
                out.println("</td>");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + ouvrage.getDisponibilite() + "</p>");
                out.println("</td>");
                out.println("</tr>");
            }
        }
    }
}
