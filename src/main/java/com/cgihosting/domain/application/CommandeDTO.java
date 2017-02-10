package com.cgihosting.domain.application;

import com.cgihosting.domain.referentiel.ReferentielEtatCommandeDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by marinib on 06/01/2017.
 */


@Entity
@Table(name="commandes_hosting")
public class CommandeDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="COH_ID")
    private int id;

    @Column(name="COH_ID_UTI_CREATEUR")
    private Integer idCreateur;

    @Column(name="COH_ID_UTI_VALIDEUR")
    private Integer idModificateur;

    @Column(name="COH_DATE_CREATION")
    private Date dateCreation;

    @Column(name="COH_DATE_MODIFICATION")
    private Date dateModification;

    @Column(name="COH_ETATCOMMANDE_ID")
    private Date idEtatComande;

    @OneToOne
    @JoinColumn(name="COH_ID_UTI_CREATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurCreateurDTO ;


    @OneToOne
    @JoinColumn(name="COH_ID_UTI_VALIDEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurValideurDTO ;


    @OneToOne
    @JoinColumn(name="COH_ETATCOMMANDE_ID", insertable = false, updatable = false)
    private ReferentielEtatCommandeDTO ReferentielEtatCommandeDTO ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdCreateur() {
        return idCreateur;
    }

    public void setIdCreateur(Integer idCreateur) {
        this.idCreateur = idCreateur;
    }

    public Integer getIdModificateur() {
        return idModificateur;
    }

    public void setIdModificateur(Integer idModificateur) {
        this.idModificateur = idModificateur;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Date getIdEtatComande() {
        return idEtatComande;
    }

    public void setIdEtatComande(Date idEtatComande) {
        this.idEtatComande = idEtatComande;
    }

    public UtilisateurDTO getUtilisateurCreateurDTO() {
        return utilisateurCreateurDTO;
    }

    public void setUtilisateurCreateurDTO(UtilisateurDTO utilisateurCreateurDTO) {
        this.utilisateurCreateurDTO = utilisateurCreateurDTO;
    }

    public UtilisateurDTO getUtilisateurValideurDTO() {
        return utilisateurValideurDTO;
    }

    public void setUtilisateurValideurDTO(UtilisateurDTO utilisateurValideurDTO) {
        this.utilisateurValideurDTO = utilisateurValideurDTO;
    }

    public com.cgihosting.domain.referentiel.ReferentielEtatCommandeDTO getReferentielEtatCommandeDTO() {
        return ReferentielEtatCommandeDTO;
    }

    public void setReferentielEtatCommandeDTO(com.cgihosting.domain.referentiel.ReferentielEtatCommandeDTO referentielEtatCommandeDTO) {
        ReferentielEtatCommandeDTO = referentielEtatCommandeDTO;
    }


}
