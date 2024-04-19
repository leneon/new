package com.example.project.dto;

import com.example.project.entities.Parametre;

public class ParametreDTO {
    private Long id;
    private String titre;
    private String type;
    private Float taux;
    private String slug;

    
    public ParametreDTO(Long id, String titre, String type, Float taux, String slug) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.taux = taux;
        this.slug = slug;
    }
    public ParametreDTO(Parametre parametre) {
        this.id = parametre.getId();
        this.titre = parametre.getTitre();
        this.type = parametre.getType();
        this.taux = parametre.gettaux();
    }
    public ParametreDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Float gettaux() {
        return taux;
    }
    public void settaux(Float taux) {
        this.taux = taux;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    
    
}
