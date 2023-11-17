package com.bibliotheque;

import Models.User;
import  Dao.ConnectionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<User> users;

    public List<User> getUsers() {
        if (users == null) {
            users = loadUsersFromDatabase();
        }
        return users;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create an instance of UserBean
        UserBean userBean = new UserBean();

        // Get the list of users
        List<User> users = userBean.getUsers();

        // Set the users attribute in the request scope
        request.setAttribute("users", users);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }

    private List<User> loadUsersFromDatabase() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM utilisateur");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setFname(resultSet.getString("nom"));
                user.setLname(resultSet.getString("prenom"));
                user.setBirthDate(resultSet.getString("DateN"));
                user.setStatus(resultSet.getString("Statut"));
                user.setRole(resultSet.getString("Role"));
                user.setType(resultSet.getString("Type"));

                userList.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return userList;
    }
}

