package com.bibliotheque;

import Models.Penalisation;
import Dao.ConnectionDao;

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

public class PenalisationBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Penalisation> penalisations;

    public List<Penalisation> getPenalisations() {
        if (penalisations == null) {
            penalisations = loadPenalisationsFromDatabase();
        }
        return penalisations;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create an instance of PenalisationBean
        PenalisationBean penalisationBean = new PenalisationBean();

        // Get the list of penalisations
        List<Penalisation> penalisations = penalisationBean.getPenalisations();

        // Set the penalisations attribute in the request scope
        request.setAttribute("penalisations", penalisations);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/penalisations.jsp").forward(request, response);
    }

    private List<Penalisation> loadPenalisationsFromDatabase() {
        List<Penalisation> penalisationList = new ArrayList<>();
        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM penaliser");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Penalisation penalisation = new Penalisation();
                penalisation.setId(resultSet.getInt("id"));
                penalisation.setDebutP(String.valueOf(resultSet.getDate("debutP").toLocalDate()));
                penalisation.setFinP(String.valueOf(resultSet.getDate("finP").toLocalDate()));

                // Retrieve nom and prenom using id_abonnee
                int idAbonnee = resultSet.getInt("id_abonnee");
                String[] nomPrenom = getNomPrenomById(idAbonnee);
                penalisation.setNomAbonnee(nomPrenom[0]);
                penalisation.setPrenomAbonnee(nomPrenom[1]);

                penalisationList.add(penalisation);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return penalisationList;
    }

    private String[] getNomPrenomById(int idAbonnee) throws SQLException, ClassNotFoundException {
        String[] nomPrenom = new String[2];

        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT nom, prenom FROM utilisateur WHERE id = ?");
        ) {
            statement.setInt(1, idAbonnee);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    nomPrenom[0] = resultSet.getString("nom");
                    nomPrenom[1] = resultSet.getString("prenom");
                }
            }
        }

        return nomPrenom;
    }
}
