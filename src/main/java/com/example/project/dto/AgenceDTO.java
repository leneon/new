package com.example.project.dto;

public class AgenceDTO {
   
    private Long id;
    private String nom;
    private String adresse;
    private String ville;
    private String localisation;

    @Override
    public String toString() {
        return "AgenceDTO [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", ville=" + ville + ", localisation="
                + localisation + "]";
    }
    public AgenceDTO(Long id, String nom, String adresse, String ville, String localisation) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.localisation = localisation;
    }

    public AgenceDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getLocalisation() {
        return localisation;
    }
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    
}
