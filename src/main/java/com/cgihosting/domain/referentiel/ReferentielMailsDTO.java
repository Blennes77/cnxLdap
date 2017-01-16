package com.cgihosting.domain.referentiel;

import com.cgihosting.domain.application.UtilisateurDTO;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by marinib on 15/01/2017.
 */

@Entity
@Table(name="referentiel_mails")
public class ReferentielMailsDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RMA_ID")
    private Integer id;

    @Column(name = "RMA_LIBELLE")
    private String libelle = "";

    @Column(name = "RMA_OBJET")
    private String objet = "";


    @Column(name = "RMA_CORPS")
    private String corps = "";

    @Column(name = "RMA_ID_CREATEUR")
    private Integer idCreateur;

    @Column(name = "RMA_ID_MODIFICATEUR")
    private Integer idModificateur;

    @Column(name = "RMA_DATE_CREATION")
    private Date dateCreation;

    @Column(name = "RMA_DATE_MODIFICATION")
    private Date dateModification;

    @OneToOne
    @JoinColumn(name = "RMA_ID_CREATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurCreateurDTO;


    @OneToOne
    @JoinColumn(name = "RMA_ID_MODIFICATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurModificateurDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
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

    public UtilisateurDTO getUtilisateurCreateurDTO() {
        return utilisateurCreateurDTO;
    }

    public void setUtilisateurCreateurDTO(UtilisateurDTO utilisateurCreateurDTO) {
        this.utilisateurCreateurDTO = utilisateurCreateurDTO;
    }

    public UtilisateurDTO getUtilisateurModificateurDTO() {
        return utilisateurModificateurDTO;
    }

    public void setUtilisateurModificateurDTO(UtilisateurDTO utilisateurModificateurDTO) {
        this.utilisateurModificateurDTO = utilisateurModificateurDTO;
    }
}
