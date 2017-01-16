package com.cgihosting.domain.referentiel;

import com.cgihosting.domain.application.UtilisateurDTO;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="referentiel_hebergeurs")
public class ReferentielHebergeurDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="RHE_ID")
    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min=0, max = 100)
    @Column(name="RHE_NOM")
    private String nom = "";

    @NotNull
    @NotEmpty
    @Size(min=0, max = 100)
    @Column(name="RHE_DESCRIPTION")
    private String description = "";

    @Column(name="RHE_ID_CREATEUR")
    private Integer idCreateur;

    @Column(name="RHE_ID_MODIFICATEUR")
    private Integer idModificateur;

    @Column(name="RHE_DATE_CREATION")
    private Date dateCreation;

    @Column(name="RHE_DATE_MODIFICATION")
    private Date dateModification;

    @OneToOne
    @JoinColumn(name="RHE_ID_CREATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurCreateurDTO ;


    @OneToOne
    @JoinColumn(name="RHE_ID_MODIFICATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurModificateurDTO ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
