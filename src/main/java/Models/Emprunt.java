package Models;

import java.util.Date;

public class Emprunt {
    private int id;
    private int idAbonnee;
    private int refOuvrage;
    private Date dateEmprunt;
    private Date dateLimit;

    // Default constructor
    public Emprunt() {
    }

    // Constructor with parameters
    public Emprunt(int id, int idAbonnee, int refOuvrage, Date dateEmprunt, Date dateLimit) {
        this.id = id;
        this.idAbonnee = idAbonnee;
        this.refOuvrage = refOuvrage;
        this.dateEmprunt = dateEmprunt;
        this.dateLimit = dateLimit;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAbonnee() {
        return idAbonnee;
    }

    public void setIdAbonnee(int idAbonnee) {
        this.idAbonnee = idAbonnee;
    }

    public int getRefOuvrage() {
        return refOuvrage;
    }

    public void setRefOuvrage(int refOuvrage) {
        this.refOuvrage = refOuvrage;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateLimit() {
        return dateLimit;
    }

    public void setDateLimit(Date dateLimit) {
        this.dateLimit = dateLimit;
    }
}

