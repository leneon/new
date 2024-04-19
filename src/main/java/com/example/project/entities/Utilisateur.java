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
@Table(name="utilisateurs")
public class Utilisateur {
    public Utilisateur() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private long id;
    @Column
    private String nom;
    @Column
    private String prenoms;

    @Column
    private String email;

    @Column
    private String telephone;

    @Column(name="username")
    private String username;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

    public Utilisateur(Agence agence) {
        this.agence = agence;
    }

    public Utilisateur(long id, String nom, String prenoms, String email, String telephone, String username,
            String password, Agence agence) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.email = email;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
        this.agence = agence;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
    
}
