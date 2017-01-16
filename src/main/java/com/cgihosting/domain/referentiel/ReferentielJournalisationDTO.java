package com.cgihosting.domain.referentiel;

import com.cgihosting.domain.application.UtilisateurDTO;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="referentiel_journalisation")
public class ReferentielJournalisationDTO {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="RJO_ID")
    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min=10, max = 100)
    @Column(name="RJO_ACTION_LIBELLE")
    private String libelleAction = "";

    @Size(min=0, max = 45)
    @Column(name="RJO_DESCRIPTION")
    private String description = "";

    @Column(name="RJO_ID_CREATEUR")
    private Integer idCreateur;

    @Column(name="RJO_ID_MODIFICATEUR")
    private Integer idModificateur;

    @Column(name="RJO_DATE_CREATION")
    private Date dateCreation;

    @Column(name="RJO_DATE_MODIFICATION")
    private Date dateModification;

    @Column(name="RJO_IND_PURGEABLE")
    private Integer indPurgeable;

    @OneToOne
    @JoinColumn(name="RJO_ID_CREATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurCreateurDTO ;


    @OneToOne
    @JoinColumn(name="RJO_ID_MODIFICATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurModificateurDTO ;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelleAction() {
        return libelleAction;
    }

    public void setLibelleAction(String libelleAction) {
        this.libelleAction = libelleAction;
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

    public Integer getIndPurgeable() {
        return indPurgeable;
    }

    public void setIndPurgeable(Integer indPurgeable) {
        this.indPurgeable = indPurgeable;
    }
}
