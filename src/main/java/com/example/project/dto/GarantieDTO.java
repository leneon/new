package com.example.project.dto;

import java.util.Date;

public class GarantieDTO {
    private Long id;
    private Date fromDate;
    private Date toDate;
    private String agence;
    private String client;
    private Double totalSales;
    private Double commissionOnSales;
    private Double totalPayements;
    private Double commissionOnPayements;
    private Double totalCommission;

    
    public GarantieDTO() {
    }
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
    public String getAgence() {
        return agence;
    }
    public void setAgence(String agence) {
        this.agence = agence;
    }
    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }
    public Double getTotalSales() {
        return totalSales;
    }
    public void setTotalSales(Double totalSales) {
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
