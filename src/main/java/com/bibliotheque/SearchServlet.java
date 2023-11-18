package com.bibliotheque;

import Dao.ConnectionDao;
import Models.User;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String query = request.getParameter("query");
        String filter = request.getParameter("filter");

        List<User> users = searchUsers(query, filter);

        sendResponse(response, users);
    }

    private List<User> searchUsers(String query, String filter) {
        List<User> userList = new ArrayList<>();

        String querySql = "SELECT * FROM utilisateur WHERE (nom LIKE ? OR prenom LIKE ?)";

        if (!filter.equals("All")) {
            querySql += " AND Type = ?";
        }else if(filter.equals("All")){
            querySql = "SELECT * FROM utilisateur WHERE nom LIKE ? OR prenom LIKE ?";
        }
        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement statement = connection.prepareStatement(querySql);
        ) {
            statement.setString(1, "%" + query + "%");
            statement.setString(2, "%" + query + "%");

            if (!filter.equals("All")) {
                statement.setString(3, filter);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setFname(resultSet.getString("nom"));
                    user.setLname(resultSet.getString("prenom"));
                    user.setBirthDate(resultSet.getString("DateN"));
                    user.setRole(resultSet.getString("Role"));
                    user.setStatus(resultSet.getString("Statut"));

                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    private void sendResponse(HttpServletResponse response, List<User> users) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Generate HTML dynamically based on the search results
            for (User user : users) {
                out.println("<tr class=\"border-b border-gray-200\">");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<div class=\"flex items-center\">");
                out.println("<div class=\"flex-shrink-0 w-11 h-10\">");
                out.println("<img class=\"w-full h-full rounded-full\" src=\"./images/user.png\" alt=\"\" />");
                out.println("</div>");
                out.println("<div class=\"ml-3\">");
                out.println("<p class=\"capitalize text-gray-900 whitespace-no-wrap\">");
                out.println("<td>" + user.getFname() + " " + user.getLname() + "</td>");
                out.println("</p>");
                out.println("</div>");
                out.println("</div>");
                out.println("</td>");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + user.getBirthDate() + "</p>");
                out.println("</td>");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"text-gray-900 whitespace-no-wrap\">" + user.getRole() + "</p>");
                out.println("</td>");
                out.println("<td class=\"px-5 py-5 bg-white text-sm\">");
                out.println("<p class=\"capitalize text-gray-900 whitespace-no-wrap\">" + user.getStatus() + "</p>");
                out.println("</td>");
                out.println("</tr>");
            }
        }
    }
}
