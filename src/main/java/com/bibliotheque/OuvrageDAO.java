package com.bibliotheque;

import Dao.ConnectionDao;
import Models.Ouvrage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OuvrageDAO {

    public void addOuvrage(Ouvrage ouvrage) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO ouvrages (REF, titre, auteur, rayon, Disponibilite) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setInt(1, ouvrage.getRef());
            preparedStatement.setString(2, ouvrage.getTitre());
            preparedStatement.setString(3, ouvrage.getAuteur());
            preparedStatement.setString(4, ouvrage.getRayon());
            preparedStatement.setInt(5, ouvrage.getDisponibilite());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteOuvrage(String ouvrageId) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
                     PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ouvrages WHERE ref = ?")) {
            preparedStatement.setString(1, ouvrageId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOuvrage(Ouvrage ouvrage) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE ouvrages SET titre = ?, auteur = ?, rayon = ?, Disponibilite = ? WHERE ref = ?")) {
            preparedStatement.setString(1, ouvrage.getTitre());
            preparedStatement.setString(2, ouvrage.getAuteur());
            preparedStatement.setString(3, ouvrage.getRayon());
            preparedStatement.setInt(4, ouvrage.getDisponibilite());
            preparedStatement.setInt(5, ouvrage.getRef());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
