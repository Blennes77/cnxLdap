package com.cgihosting.domain.referentiel;

import com.cgihosting.domain.application.UtilisateurDTO;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by marinib on 08/01/2017.
 */

@Entity
@Table(name="referentiel_os")
public class ReferentielOSDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="REO_ID")
    private Integer id;

    @Column(name="REO_NOMOS")
    private String nomOS = "";

    @Column(name="REO_ID_CREATEUR")
    private Integer idCreateur;

    @Column(name="REO_ID_MODIFICATEUR")
    private Integer idModificateur;

    @Column(name="REO_DATE_CREATION")
    private Date dateCreation;

    @Column(name="REO_DATE_MODIFICATION")
    private Date dateModification;

    @OneToOne
    @JoinColumn(name="REO_ID_CREATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurCreateurDTO ;


    @OneToOne
    @JoinColumn(name="REO_ID_MODIFICATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurModificateurDTO ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomOS() {
        return nomOS;
    }

    public void setNomOS(String nomOS) {
        this.nomOS = nomOS;
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
