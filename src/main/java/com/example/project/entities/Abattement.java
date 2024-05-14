package com.example.project.entities;


import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "abattements")
public class Abattement {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private long id;
    @Column
    private Date date;
    @Column
    private Integer journee;
    @ManyToOne
    @JoinColumn
    private Client client;
    @Column
    private Double vente;
    @Column
    private Double paiement;
    @Column(name = "solde_a_verser")
    private Double soldeAVerser;
    @Column 
    private Double reg;
    @Column (name = "non_reg")
    private Double nonReg;
    @Column (name = "total")
    private Double total;

    @OneToMany(mappedBy = "abattement", cascade = CascadeType.ALL)
    private List<AbattementParametre> listAbatttementParametres;

    public Abattement(long id, Date date, Client client, Double vente, Double paiement, Double soldeAVerser, Double reg,
            Double nonReg, Double total) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.vente = vente;
        this.paiement = paiement;
        this.soldeAVerser = soldeAVerser;
        this.reg = reg;
        this.nonReg = nonReg;
        this.total = total;
    }
    public Abattement() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Double getVente() {
        return vente;
    }
    public void setVente(Double vente) {
        this.vente = vente;
    }
    public Double getPaiement() {
        return paiement;
    }
    public void setPaiement(Double paiement) {
        this.paiement = paiement;
    }
    public Double getSoldeAVerser() {
        return soldeAVerser;
    }
    public void setSoldeAVerser(Double soldeAVerser) {
        this.soldeAVerser = soldeAVerser;
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
    public Integer getJournee() {
        return journee;
    }
    public void setJournee(Integer journee) {
        this.journee = journee;
    }
    public List<AbattementParametre> getListAbatttementParametres() {
        return listAbatttementParametres;
    }
    public void setListAbatttementParametres(List<AbattementParametre> listAbatttementParametres) {
        this.listAbatttementParametres = listAbatttementParametres;
    }
    
    
    
}
