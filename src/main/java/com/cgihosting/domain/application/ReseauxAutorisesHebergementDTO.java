package com.cgihosting.domain.application;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 15/01/2017.
 */

@Entity
@Table(name="reseaux_autorises_hebergement")
public class ReseauxAutorisesHebergementDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RAH_ID")
    private int Integer;

    @Column(name = "RAH_MASQUE_CICDR")
    private Integer masqueCicdr;

    @Column(name = "RAH_ADRESSE_RESEAU")
    private String adresseReseau;

    @Column(name = "RAH_ORDRE")
    private Integer ordre;

    @Column(name = "RAH_ID_SOLUTION_HEBERGEMENT")
    private Integer idSolutionHebergement;

    @Column(name = "RAH_IND_ACTIF")
    private Integer indActif;

    @Column(name="RAH_ID_TYE_ENVIRONNEMENT")
    private Integer idTypeEnvironnement;


    public int getInteger() {
        return Integer;
    }

    public void setInteger(int integer) {
        Integer = integer;
    }

    public java.lang.Integer getMasqueCicdr() {
        return masqueCicdr;
    }

    public void setMasqueCicdr(java.lang.Integer masqueCicdr) {
        this.masqueCicdr = masqueCicdr;
    }

    public java.lang.Integer getIdSolutionHebergement() {
        return idSolutionHebergement;
    }

    public void setIdSolutionHebergement(java.lang.Integer idSolutionHebergement) {
        this.idSolutionHebergement = idSolutionHebergement;
    }

    public java.lang.Integer getIndActif() {
        return indActif;
    }

    public void setIndActif(java.lang.Integer indActif) {
        this.indActif = indActif;
    }

    public java.lang.Integer getIdTypeEnvironnement() {
        return idTypeEnvironnement;
    }

    public void setIdTypeEnvironnement(java.lang.Integer idTypeEnvironnement) {
        this.idTypeEnvironnement = idTypeEnvironnement;
    }

    public String getAdresseReseau() {
        return adresseReseau;
    }

    public void setAdresseReseau(String adresseReseau) {
        this.adresseReseau = adresseReseau;
    }

    public java.lang.Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(java.lang.Integer ordre) {
        this.ordre = ordre;
    }
}


