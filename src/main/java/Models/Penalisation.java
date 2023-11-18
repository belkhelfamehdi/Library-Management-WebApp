package Models;

import java.time.LocalDate;

public class Penalisation {
    private int id;
    private int idAbonnee;
    private String debutP;
    private String finP;
    private String nomAbonnee;
    private String prenomAbonnee;


    public Penalisation() {
    }
    public Penalisation(int id, int idAbonnee, String debutP, String finP, String nomAbonnee, String prenomAbonnee) {
        this.id = id;
        this.idAbonnee = idAbonnee;
        this.debutP = debutP;
        this.finP = finP;
        this.nomAbonnee = nomAbonnee;
        this.prenomAbonnee = prenomAbonnee;
    }


    public int getId() {
        return id;
    }


    public String getPrenomAbonnee() {
        return prenomAbonnee;
    }

    public void setPrenomAbonnee(String prenomAbonnee) {
        this.prenomAbonnee = prenomAbonnee;
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

    public String getDebutP() {
        return debutP;
    }

    public void setDebutP(String debutP) {
        this.debutP = debutP;
    }

    public String getFinP() {
        return finP;
    }

    public void setFinP(String finP) {
        this.finP = finP;
    }

    public String getNomAbonnee() {
        return nomAbonnee;
    }

    public void setNomAbonnee(String nomAbonnee) {
        this.nomAbonnee = nomAbonnee;
    }
}
