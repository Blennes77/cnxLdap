package com.cgihosting.domain.referentiel;

import com.cgihosting.domain.application.UtilisateurDTO;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by garnons on 06/12/2016.
 */
@Entity
@Table(name="referentiel_role_utilisateur")
public class ReferentielRolesDTO implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RRU_ID")
    private int id;

    @NotNull
    @NotEmpty
    @Size(min=10, max = 100)
    @Column(name="RRU_LIBELLE_ROLE")
    private String libelleRole;

    @Column(name="RRU_DESCRIPTION_ROLE")
    @NotNull
    private String descriptionRole;

    @Column(name="RRU_ID_CREATEUR")
    private Integer idCreateur;

    @Column(name="RRU_ID_MODIFICATEUR")
    private Integer idModificateur;

    @Column(name="RRU_DATE_CREATION")
    private Date dateCreation;

    @Column(name="RRU_DATE_MODIFICATION")
    private Date dateModification;


    @OneToOne
    @JoinColumn(name="RRU_ID_CREATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurCreateurDTO ;


    @OneToOne
    @JoinColumn(name="RRU_ID_MODIFICATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurModificateurDTO ;

    public ReferentielRolesDTO() {
    }

    public ReferentielRolesDTO(int id){
        this.id = id;
    }

    public ReferentielRolesDTO(String libelleRole) {
        this.libelleRole = libelleRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelleRole() {
        return libelleRole;
    }

    public void setLibelleRole(String libelleRole) {
        this.libelleRole = libelleRole;
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


    public String getDescriptionRole() {
        return descriptionRole;
    }

    public void setDescriptionRole(String descriptionRole) {
        this.descriptionRole = descriptionRole;
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
