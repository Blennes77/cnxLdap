package com.cgihosting.domain.referentiel;

import com.cgihosting.domain.application.UtilisateurDTO;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by marinib on 10/02/2017.
 */

@Entity
@Table(name="referentiel_etatcommande")
public class ReferentielEtatCommandeDTO {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="REC_ID")
    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min=1, max = 100)
    @Column(name="REC_LIBELLE")
    private String libelle = "";

    @Size(min=0, max = 45)
    @Column(name="REC_DESCRIPTION")
    private String description = "";

    @Column(name="REC_ID_CREATEUR")
    private Integer idCreateur;

    @Column(name="REC_ID_MODIFICATEUR")
    private Integer idModificateur;

    @Column(name="REC_DATE_CREATION")
    private Date dateCreation;

    @Column(name="REC_DATE_MODIFICATION")
    private Date dateModification;

    @Column(name="REC_IND_PURGEABLE")
    private Integer indPurgeable;

    @OneToOne
    @JoinColumn(name="REC_ID_CREATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurCreateurDTO ;


    @OneToOne
    @JoinColumn(name="REC_ID_MODIFICATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurModificateurDTO ;


    @OneToOne
    @JoinColumn(name="REC_IND_PURGEABLE", insertable = false, updatable = false)
    private ReferentielIndActifDTO referentielIndActifDTO ;

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

    public Integer getIndPurgeable() {
        return indPurgeable;
    }

    public void setIndPurgeable(Integer indPurgeable) {
        this.indPurgeable = indPurgeable;
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

    public ReferentielIndActifDTO getReferentielIndActifDTO() {
        return referentielIndActifDTO;
    }

    public void setReferentielIndActifDTO(ReferentielIndActifDTO referentielIndActifDTO) {
        this.referentielIndActifDTO = referentielIndActifDTO;
    }
}
