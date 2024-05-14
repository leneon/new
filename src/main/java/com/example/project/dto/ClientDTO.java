package com.example.project.dto;

import java.util.Date;

import com.example.project.entities.Agence;
import com.example.project.entities.Client;

public class ClientDTO {
    private long id;
    private String numeroOp;
    private String banque;
    private String zone;
    private String localite;
    private String agence;
    private String caisse;
    private Date datecreation;


    public ClientDTO() {
    }

    public ClientDTO(Client client){
        this.id = client.getId();
        this.numeroOp = client.getNumeroOp();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNumeroOp() {
        return numeroOp;
    }
    public void setNumeroOp(String numeroOp) {
        this.numeroOp = numeroOp;
    }
    public String getBanque() {
        return banque;
    }
    public void setBanque(String banque) {
        this.banque = banque;
    }
    public String getZone() {
        return zone;
    }
    public void setZone(String zone) {
        this.zone = zone;
    }
    public String getLocalite() {
        return localite;
    }
    public void setLocalite(String localite) {
        this.localite = localite;
    }
    public String getAgence() {
        return agence;
    }
    public void setAgence(String agence) {
        this.agence = agence;
    }
    public String getCaisse() {
        return caisse;
    }
    public void setCaisse(String caisse) {
        this.caisse = caisse;
    }
    public Date getDatecreation() {
        return datecreation;
    }
    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

   
    

}
