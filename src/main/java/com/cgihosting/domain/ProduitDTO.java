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
    private int id;

    @Column(name="RPR_TYPE_ID")
    private int typeProduit;

    @Column(name="RPR_DESCRIPTION")
    private String description;

    @Column(name="RPR_CODE")
    private String codeProduit;

    @Column(name="RPR_LIBELLE")
    private String libelleProduit;

    @Column(name="RPR_PRIX_UNITAIRE")
    private int prixUnitaire;

    @Column(name="RPR_DOLIBARR_ID")
    private int  dolibarrId;

    @Column(name="RPR_HEBERGEUR_ID")
    private int hebergeurId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(int typeProduit) {
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

    public int getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(int prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getDolibarrId() {
        return dolibarrId;
    }

    public void setDolibarrId(int dolibarrId) {
        this.dolibarrId = dolibarrId;
    }

    public int getHebergeurId() {
        return hebergeurId;
    }

    public void setHebergeurId(int hebergeurId) {
        this.hebergeurId = hebergeurId;
    }
}
