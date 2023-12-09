package com.bibliotheque;

import Dao.ConnectionDao;
import Models.Emprunt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpruntDAO {

    public static void addEmprunt(Emprunt emprunt) {
        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO emprunt (id_abonnee, ref_ouvrage, date_emprunt, date_limit) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setInt(1, emprunt.getIdAbonnee());
            preparedStatement.setInt(2, emprunt.getRefOuvrage());
            preparedStatement.setDate(3, new java.sql.Date(emprunt.getDateEmprunt().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(emprunt.getDateLimit().getTime()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEmprunt(int empruntId) {
        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM emprunt WHERE id = ?")) {

            preparedStatement.setInt(1, empruntId);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateEmprunt(Emprunt emprunt) {
        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE emprunt SET id_abonnee = ?, ref_ouvrage = ?, date_emprunt = ?, date_limit = ? WHERE id = ?")) {

            preparedStatement.setInt(1, emprunt.getIdAbonnee());
            preparedStatement.setInt(2, emprunt.getRefOuvrage());
            preparedStatement.setDate(3, new java.sql.Date(emprunt.getDateEmprunt().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(emprunt.getDateLimit().getTime()));
            preparedStatement.setInt(5, emprunt.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Log or handle the exception as needed
        }
    }

    static public int getEmpruntByUserId(int userId) {
        int empruntCount = 0;

        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM emprunt WHERE id_abonnee = ?");
        ) {
            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    empruntCount = resultSet.getInt(1);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return empruntCount;
    }

    public static boolean empruntExists(int idAbonnee, int refOuvrage) {
        boolean exists = false;

        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM emprunt WHERE id_abonnee = ? AND ref_ouvrage = ?")) {

            preparedStatement.setInt(1, idAbonnee);
            preparedStatement.setInt(2, refOuvrage);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                exists = resultSet.next(); // Check if a row exists
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return exists;
    }
}