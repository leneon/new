package com.example.project.dto;

import com.example.project.entities.Agence;

public class UtilisateurDTO {
    private long id;
    private String nom;
    private String prenoms;
    private String email;
    private String telephone;
    private String username;
    private Agence agence;
    public UtilisateurDTO() {
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
    public Agence getAgence() {
        return agence;
    }
    public void setAgence(Agence agence) {
        this.agence = agence;
    }

}
