package com.bibliotheque;

import Dao.ConnectionDao;
import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
