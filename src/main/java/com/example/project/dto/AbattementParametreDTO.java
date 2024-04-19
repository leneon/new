package com.example.project.dto;

import com.example.project.entities.AbattementParametre;
import com.example.project.entities.Parametre;

public class AbattementParametreDTO {
    private Long id;
    private Long abattement;
    private ParametreDTO parametre;
    private String valeur;
    private Double montantAbattement;
    
    public AbattementParametreDTO() {
    }
    public AbattementParametreDTO(AbattementParametre ab) {
        this.id = ab.getId();
        this.abattement = ab.getAbattement().getId();
        this.parametre = new ParametreDTO(ab.getParametre());
        this.valeur = ab.getvaleur();
        this.montantAbattement = ab.getMontantAbattement();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getAbattement() {
        return abattement;
    }
    public void setAbattement(Long abattement) {
        this.abattement = abattement;
    }
    public ParametreDTO getParametre() {
        return parametre;
    }
    public void setParametre(ParametreDTO parametre) {
        this.parametre = parametre;
    }
    public String getvaleur() {
        return valeur;
    }
    public void setvaleur(String valeur) {
        this.valeur = valeur;
    }
    public Double getMontantAbattement() {
        return montantAbattement;
    }
    public void setMontantAbattement(Double montantAbattement) {
        this.montantAbattement = montantAbattement;
    }

    
}
