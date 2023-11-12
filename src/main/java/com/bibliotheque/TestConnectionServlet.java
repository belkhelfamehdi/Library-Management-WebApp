package com.bibliotheque;
import Dao.ConnectionDao;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TestConnectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String connectionStatus = testConnection();
        request.setAttribute("connectionStatus", connectionStatus);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private String testConnection() {
        String status;
        try {
            Connection connection = ConnectionDao.getConnection();
            if (connection != null && !connection.isClosed()) {
                status = "Connected to the database.";
                connection.close();
            } else {
                status = "Not connected to the database.";
            }
        } catch (Exception e) {
            status = "Connection error: " + e.getMessage();
        }
        return status;
    }
}
