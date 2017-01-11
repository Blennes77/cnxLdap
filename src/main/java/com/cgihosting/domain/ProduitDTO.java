package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="ref_produits")
public class ProduitDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="RPR_ID")
    private int Integer;

    @Column(name="RPR_TYPE_ID")
    private Integer typeProduit;

    @Column(name="RPR_DESCRIPTION")
    private String description;

    @Column(name="RPR_CODE")
    private String codeProduit;

    @Column(name="RPR_LIBELLE")
    private String libelleProduit;

    @Column(name="RPR_PRIX_UNITAIRE")
    private Integer prixUnitaire;

    @Column(name="RPR_DOLIBARR_ID")
    private Integer  dolibarrId;

    @Column(name="RPR_HEBERGEUR_ID")
    private Integer hebergeurId;

    public int getInteger() {
        return Integer;
    }

    public void setInteger(int integer) {
        Integer = integer;
    }

    public java.lang.Integer getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(java.lang.Integer typeProduit) {
        this.typeProduit = typeProduit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public java.lang.Integer getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(java.lang.Integer prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public java.lang.Integer getDolibarrId() {
        return dolibarrId;
    }

    public void setDolibarrId(java.lang.Integer dolibarrId) {
        this.dolibarrId = dolibarrId;
    }

    public java.lang.Integer getHebergeurId() {
        return hebergeurId;
    }

    public void setHebergeurId(java.lang.Integer hebergeurId) {
        this.hebergeurId = hebergeurId;
    }
}
