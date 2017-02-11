package com.cgihosting.domain.application;


import com.cgihosting.domain.referentiel.ReferentielEtatCommandeDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by marinib 11/02/2017.
 */
@Entity
@Table(name = "commande_a_traitement")

public class TraitementCommandeDTO implements Serializable{


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="CAT_ID")
    private Integer id;

    @Column(name="CAT_COH_ID")
    private Integer idCommande;


    @Column(name="CAT_REC_ID")
    private Integer idEtatCommande;

    @Column(name="CAT_DATE_TRAITEMENT")
    @NotNull
    private Date dateTraitement;

    @Column(name="CAT_UTI_ID")
    private Integer idUser;

    @Column(name="CAT_IND_EN_COURS")
    private int indEnCours;

    @OneToOne
    @JoinColumn(name = "CAT_UTI_ID", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurDTO;


    @OneToOne
    @JoinColumn(name = "CAT_REC_ID", insertable = false, updatable = false)
    private ReferentielEtatCommandeDTO referentielEtatCommandeDTO;



    public TraitementCommandeDTO() {
    }

    public TraitementCommandeDTO(Integer idCommande, Integer idEtatCommande) {
        this.idCommande = idCommande;
        this.idEtatCommande = idEtatCommande;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Integer getIdEtatCommande() {
        return idEtatCommande;
    }

    public void setIdEtatCommande(Integer idEtatCommande) {
        this.idEtatCommande = idEtatCommande;
    }

    public Date getDateTraitement() {
        return dateTraitement;
    }

    public void setDateTraitement(Date dateTraitement) {
        this.dateTraitement = dateTraitement;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public int getIndEnCours() {
        return indEnCours;
    }

    public void setIndEnCours(int indEnCours) {
        this.indEnCours = indEnCours;
    }

    public UtilisateurDTO getUtilisateurDTO() {
        return utilisateurDTO;
    }

    public void setUtilisateurDTO(UtilisateurDTO utilisateurDTO) {
        this.utilisateurDTO = utilisateurDTO;
    }

    public ReferentielEtatCommandeDTO getReferentielEtatCommandeDTO() {
        return referentielEtatCommandeDTO;
    }

    public void setReferentielEtatCommandeDTO(ReferentielEtatCommandeDTO referentielEtatCommandeDTO) {
        this.referentielEtatCommandeDTO = referentielEtatCommandeDTO;
    }



}
