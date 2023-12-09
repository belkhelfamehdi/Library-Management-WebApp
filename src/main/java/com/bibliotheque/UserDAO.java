package com.bibliotheque;

import Dao.ConnectionDao;
import Models.User;

import java.sql.*;

public class UserDAO {

    public static User checkLogin(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = ConnectionDao.getConnection();

            String query = "SELECT * FROM utilisateur WHERE id = ? AND MotDePasse = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setFname(rs.getString("prenom"));
                user.setLname(rs.getString("nom"));
                user.setBirthDate(rs.getString("DateN"));
                user.setStatus(rs.getString("Statut"));
                user.setRole(rs.getString("Role"));
                user.setType(rs.getString("Type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
    public void addUser(User user) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO utilisateur (nom, prenom, DateN, MotDePasse, Role, Statut, Type) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, user.getFname());
            preparedStatement.setString(2, user.getFname());
            preparedStatement.setString(3, user.getBirthDate());
            preparedStatement.setString(4, user.getBirthDate());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getStatus());
            preparedStatement.setString(7, user.getType());
            System.out.println(user.getBirthDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE utilisateur SET nom=?, prenom=?, DateN=?, MotDePasse=?, Role=?, Statut=?, Type=? WHERE id=?")) {

            preparedStatement.setString(1, user.getLname());
            preparedStatement.setString(2, user.getFname());
            preparedStatement.setString(3, user.getBirthDate());
            preparedStatement.setString(4, user.getBirthDate());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getStatus());
            preparedStatement.setString(7, user.getType());
            preparedStatement.setInt(8, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String userId) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM utilisateur WHERE id = ?")) {
            preparedStatement.setString(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
