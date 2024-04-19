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
@Table(name="clients")
public class Client {
    public Client(long id) {
        this.id = id;
    }

    public Client() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private long id;

    @Column(name="numero_op")
    private String numeroOp;

    @Column
    private String banque;

    @Column
    private String zone;

    @Column
    private String localite;

    @Column
    private String caisse;

    @Column(name = "date_creation")
    private Date datecreation;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

    public Client(long id, String numeroOp, String banque, String zone, String localite, String caisse,
            Date datecreation, Agence agence) {
        this.id = id;
        this.numeroOp = numeroOp;
        this.banque = banque;
        this.zone = zone;
        this.localite = localite;
        this.caisse = caisse;
        this.datecreation = datecreation;
        this.agence = agence;
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

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", numeroOp=" + numeroOp + ", banque=" + banque + ", zone=" + zone + ", localite="
                + localite + ", caisse=" + caisse + ", datecreation=" + datecreation + ", agence=" + agence + "]";
    }
    

}
