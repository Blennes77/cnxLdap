package com.cgihosting.domain.referentiel;

import com.cgihosting.domain.application.UtilisateurDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by marinib on 09/01/2017.
 */

@Entity
@Table(name="referentiel_actions_workflows")
public class ReferentielActionsWorkflowDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="RAW_ID")
    private Integer id;

    @Column(name="RAW_ACTION_WORKFLOW")
    private String actionWorkflow = "";

    @Column(name="RAW_DESCRIPTION_WORKFLOW")
    private String descriptionWorkflow = "";

    @Column(name="RAW_ID_CREATEUR")
    private Integer idCreateur;

    @Column(name="RAW_ID_MODIFICATEUR")
    private Integer idModificateur;

    @Column(name="RAW_DATE_CREATION")
    private Date dateCreation;

    @Column(name="RAW_DATE_MODIFICATION")
    private Date dateModification;

    @OneToOne
    @JoinColumn(name="RAW_ID_CREATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurCreateurDTO ;


    @OneToOne
    @JoinColumn(name="RAW_ID_MODIFICATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurModificateurDTO ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionWorkflow() {
        return actionWorkflow;
    }

    public void setActionWorkflow(String actionWorkflow) {
        this.actionWorkflow = actionWorkflow;
    }

    public String getDescriptionWorkflow() {
        return descriptionWorkflow;
    }

    public void setDescriptionWorkflow(String descriptionWorkflow) {
        this.descriptionWorkflow = descriptionWorkflow;
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
