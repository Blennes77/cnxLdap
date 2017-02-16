package com.cgihosting.domain.application;

import com.cgihosting.domain.referentiel.ReferentielEtatTraitementServeurDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by marinib 05/02/2017.
 */
@Entity
@Table(name = "serveur_virtuel_a_traitement")
@NamedQuery(
        name="findAllTraitementAEffectuer",
        query="SELECT t FROM TraitementServeurVirtuelDTO t WHERE t.indEnCours = :indEnCours AND t.idTraitement = :idTraitement"
)
public class TraitementServeurVirtuelDTO implements Serializable{


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="SAT_ID")
    private Integer id;

    @Column(name="SAT_SVI_ID")
    private Integer idServeur;


    @Column(name="SAT_RES_ID")
    private Integer idTraitement;

    @Column(name="SAT_DATE_TRAITEMENT")
    @NotNull
    private Date dateTraitement;

    @Column(name="SAT_UTI_ID")
    private Integer idUser;

    @Column(name="SAT_IND_EN_COURS")
    private int indEnCours;

    @OneToOne
    @JoinColumn(name = "SAT_UTI_ID", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurDTO;


    @OneToOne
    @JoinColumn(name = "SAT_RES_ID", insertable = false, updatable = false)
    private ReferentielEtatTraitementServeurDTO referentielEtatTraitementServeurDTO;



    public TraitementServeurVirtuelDTO() {
    }

    public TraitementServeurVirtuelDTO(Integer idServeur, Integer idTraitement, Date dateTraitement, Integer indEnCours, Integer idUser) {
        this.idServeur = idServeur;
        this.idTraitement = idTraitement;
        this.dateTraitement = dateTraitement;
        this.indEnCours = indEnCours;
        this.idUser = idUser;
    }

    public Integer getIdServeur() {
        return idServeur;
    }

    public void setIdServeur(Integer idServeur) {
        this.idServeur = idServeur;
    }

    public Integer getIdTraitement() {
        return idTraitement;
    }

    public void setIdTraitement(Integer idTraitement) {
        this.idTraitement = idTraitement;
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

    public ReferentielEtatTraitementServeurDTO getReferentielEtatTraitementServeurDTO() {
        return referentielEtatTraitementServeurDTO;
    }

    public void setReferentielEtatTraitementServeurDTO(
            ReferentielEtatTraitementServeurDTO referentielEtatTraitementServeurDTO) {
        this.referentielEtatTraitementServeurDTO = referentielEtatTraitementServeurDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
