package com.cgihosting.domain.referentiel;



import javax.persistence.*;
import java.util.Date;

/**
 * Created by marinib on 05/02/2017.
 */

@Entity
@Table(name="referentiel_psa")
public class ReferentielPSADTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    @Column(name="IPAYS")
    private String pays;

    @Column(name="OU")
    private String ou;

    @Column(name="LIBELLE_OU")
    private String libelleOU;

    @Column(name="PROJET")
    private String projet;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="DPT")
    private String dpt;

    @Column(name="LIBELLE")
    private String libelle;

    @Column(name="MATRICULE_PM")
    private String matriculePM;

    @Column(name="NOM_PM")
    private String nomPM;

    @Column(name="PRENOM_PM")
    private String prenomPM;

    @Column(name="MAIL_PM")
    private String mailPM;

    @Column(name="DATE_DEBUT")
    private Date dateDebut;

    @Column(name="DATE_FIN")
    private Date dateFin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getOu() {
        return ou;
    }

    public void setOu(String ou) {
        this.ou = ou;
    }

    public String getLibelleOU() {
        return libelleOU;
    }

    public void setLibelleOU(String libelleOU) {
        this.libelleOU = libelleOU;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMatriculePM() {
        return matriculePM;
    }

    public void setMatriculePM(String matriculePM) {
        this.matriculePM = matriculePM;
    }

    public String getNomPM() {
        return nomPM;
    }

    public void setNomPM(String nomPM) {
        this.nomPM = nomPM;
    }

    public String getPrenomPM() {
        return prenomPM;
    }

    public void setPrenomPM(String prenomPM) {
        this.prenomPM = prenomPM;
    }

    public String getMailPM() {
        return mailPM;
    }

    public void setMailPM(String mailPM) {
        this.mailPM = mailPM;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }





}
