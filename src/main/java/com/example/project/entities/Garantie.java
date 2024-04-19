package com.example.project.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="garanties")
public class Garantie {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private  Date fromDate;
    @Column
    private  Date toDate;
    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name="total_sales")
    private double totalSales;
    @Column(name="commission_on_sales")
    private Double commissionOnSales;
    @Column(name="total_payements")
    private Double totalPayements;
    @Column(name="commission_on_payements")
    private Double commissionOnPayements;
    @Column(name="total_commission")
    private Double totalCommission;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getFromDate() {
        return fromDate;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    public Date getToDate() {
        return toDate;
    }
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    public Agence getAgence() {
        return agence;
    }
    public void setAgence(Agence agence) {
        this.agence = agence;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public double getTotalSales() {
        return totalSales;
    }
    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
    public Double getCommissionOnSales() {
        return commissionOnSales;
    }
    public void setCommissionOnSales(Double commissionOnSales) {
        this.commissionOnSales = commissionOnSales;
    }
    public Double getTotalPayements() {
        return totalPayements;
    }
    public void setTotalPayements(Double totalPayements) {
        this.totalPayements = totalPayements;
    }
    public Double getCommissionOnPayements() {
        return commissionOnPayements;
    }
    public void setCommissionOnPayements(Double commissionOnPayements) {
        this.commissionOnPayements = commissionOnPayements;
    }
    public Double getTotalCommission() {
        return totalCommission;
    }
    public void setTotalCommission(Double totalCommission) {
        this.totalCommission = totalCommission;
    }


}
