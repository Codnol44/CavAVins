package fr.eni.bo;

import java.time.LocalDate;

public class Bouteille {
    private int id_B;
    private String region;
    private String appellation;
    private String domaine;
    private int annee;
    private int prix;

    public Bouteille(int id_B, String region, String appellation, String domaine, int annee, int prix) {
        this.id_B = id_B;
        this.region = region;
        this.appellation = appellation;
        this.domaine = domaine;
        this.annee = annee;
        this.prix = prix;
    }

    public Bouteille(String region, String appellation, String domaine, int annee, int prix) {
        this.region = region;
        this.appellation = appellation;
        this.domaine = domaine;
        this.annee = annee;
        this.prix = prix;
    }

    public Bouteille(String region, String appellation, String domaine) {
        this.region = region;
        this.appellation = appellation;
        this.domaine = domaine;
    }

    public Bouteille() {
    }

    public int getId_B() {
        return id_B;
    }

    public String getRegion() {
        return region;
    }

    public String getAppellation() {
        return appellation;
    }

    public String getDomaine() {
        return domaine;
    }

    public int getAnnee() {
        return annee;
    }

    public int getPrix() {
        return prix;
    }

    public void setId_B(int id_B) {
        this.id_B = id_B;
    }
}
