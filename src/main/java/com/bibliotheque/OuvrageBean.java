package com.bibliotheque;

import Models.Ouvrage;
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

public class OuvrageBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Ouvrage> ouvrages;

    public List<Ouvrage> getOuvrages() {
        if (ouvrages == null) {
            ouvrages = loadOuvragesFromDatabase();
        }
        return ouvrages;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create an instance of OuvrageBean
        OuvrageBean ouvrageBean = new OuvrageBean();

        // Get the list of ouvrages
        List<Ouvrage> ouvrages = ouvrageBean.getOuvrages();

        // Set the ouvrages attribute in the request scope
        request.setAttribute("ouvrages", ouvrages);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }

    private List<Ouvrage> loadOuvragesFromDatabase() {
        List<Ouvrage> ouvrageList = new ArrayList<>();
        try (Connection connection = ConnectionDao.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM ouvrages");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Ouvrage ouvrage = new Ouvrage();
                ouvrage.setRef(resultSet.getInt("Ref"));
                ouvrage.setTitre(resultSet.getString("titre"));
                ouvrage.setAuteur(resultSet.getString("auteur"));
                ouvrage.setRayon(resultSet.getString("rayon"));
                ouvrage.setDisponibilite(resultSet.getInt("Disponibilite"));

                ouvrageList.add(ouvrage);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ouvrageList;
    }
}
