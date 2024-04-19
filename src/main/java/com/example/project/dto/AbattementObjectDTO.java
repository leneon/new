package com.example.project.dto;

import java.sql.Time;
import java.util.Date;
import java.util.List;



public class AbattementObjectDTO {
    private Long id;
    private ClientDTO client;
    private Date date;
    private Integer journee;
    private Double vente;
    private Double solde_a_verser;
    private Double paiement;
    private Double reg;
    private Double nonReg;
    private Double total;
    private List<String> parametres;
    private Time heure;

    public AbattementObjectDTO() {
    }

    

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public ClientDTO getClient() {
        return client;
    }


    public void setClient(ClientDTO client) {
        this.client = client;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public Double getVente() {
        return vente;
    }


    public void setVente(Double vente) {
        this.vente = vente;
    }


    public Double getSolde_a_verser() {
        return solde_a_verser;
    }


    public void setSolde_a_verser(Double solde_a_verser) {
        this.solde_a_verser = solde_a_verser;
    }


    public Double getPaiement() {
        return paiement;
    }


    public void setPaiement(Double paiement) {
        this.paiement = paiement;
    }


    public Double getReg() {
        return reg;
    }


    public void setReg(Double reg) {
        this.reg = reg;
    }


    public Double getNonReg() {
        return nonReg;
    }


    public void setNonReg(Double nonReg) {
        this.nonReg = nonReg;
    }


    public Double getTotal() {
        return total;
    }


    public void setTotal(Double total) {
        this.total = total;
    }



    public java.util.List<String> getParametres() {
        return  parametres;
    }



    public void setParametres(List<String>  parametres) {
        this.parametres = parametres;
    }



    public Time getHeure() {
        return heure;
    }



    public void setHeure(Time heure) {
        this.heure = heure;
    }



    public Integer getJournee() {
        return journee;
    }



    public void setJournee(Integer journee) {
        this.journee = journee;
    }




    
}
