package com.bibliotheque;

import Dao.ConnectionDao;
import Models.Emprunt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpruntBean {
    public List<Emprunt> getEmprunts() {
        List<Emprunt> emprunts = new ArrayList<>();

        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM emprunt");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Emprunt emprunt = new Emprunt();
                emprunt.setId(resultSet.getInt("id"));
                emprunt.setIdAbonnee(resultSet.getInt("id_abonnee"));
                emprunt.setRefOuvrage(resultSet.getInt("ref_ouvrage"));
                emprunt.setDateEmprunt(resultSet.getDate("date_emprunt"));
                emprunt.setDateLimit(resultSet.getDate("date_limit"));

                emprunts.add(emprunt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return emprunts;
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
}