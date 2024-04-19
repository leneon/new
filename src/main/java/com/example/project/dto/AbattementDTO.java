package com.example.project.dto;

import java.util.Date;
import java.util.List;

public class AbattementDTO {
public AbattementDTO() {
    }
private Long id;
private ClientDTO client;
private Date date;
private Double vente;
private Integer journee;
private Double soldeAVerser;
private Double paiement;
private Double reg;
private Double nonReg;
private Double total;
private List<AbattementParametreDTO> listeAbattementParametres;

public Integer getJournee() {
    return journee;
}
public void setJournee(Integer journee) {
    this.journee = journee;
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
public Double getSoldeAVerser() {
    return soldeAVerser;
}
public void setSoldeaverser(Double soldeAVerser) {
    this.soldeAVerser = soldeAVerser;
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
public List<AbattementParametreDTO> getListeAbattementParametres() {
    return listeAbattementParametres;
}
public void setListeAbattementParametres(List<AbattementParametreDTO> listeAbattementParametres) {
    this.listeAbattementParametres = listeAbattementParametres;
}



}
