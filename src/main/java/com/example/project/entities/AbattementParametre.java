package com.example.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="abattement_parametres")
public class AbattementParametre {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private long id;

    @ManyToOne
    @JoinColumn(name = "abattement", referencedColumnName = "id")
    private Abattement abattement;
    @ManyToOne
    @JoinColumn(name = "parametre", referencedColumnName = "id")
    private Parametre parametre;
    @Column
    private String valeur;
    @Column(name = "montant_abattement")
    private Double montantAbattement;
    
    public AbattementParametre(long id, Abattement abattement, Parametre parametre, String valeur,
            Double montantAbattement) {
        this.id = id;
        this.abattement = abattement;
        this.parametre = parametre;
        this.valeur = valeur;
        this.montantAbattement = montantAbattement;
    }
    public AbattementParametre() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Abattement getAbattement() {
        return abattement;
    }
    public void setAbattement(Abattement abattement) {
        this.abattement = abattement;
    }
    public Parametre getParametre() {
        return parametre;
    }
    public void setParametre(Parametre parametre) {
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
