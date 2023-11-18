package Models;

public class Ouvrage {
    private int ref;
    private String titre;
    private String auteur;
    private String rayon;
    private int disponibilite;

    // Default constructor
    public Ouvrage() {
    }

    // Constructor with parameters
    public Ouvrage(int ref, String titre, String auteur, String rayon, int disponibilite) {
        this.ref = ref;
        this.titre = titre;
        this.auteur = auteur;
        this.rayon = rayon;
        this.disponibilite = disponibilite;
    }

    // Getters and Setters
    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getRayon() {
        return rayon;
    }

    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    public int getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }
}

