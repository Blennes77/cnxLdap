package com.cgihosting.domain.application;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by marinib 05/02/2017.
 */
@Entity
@IdClass (TraitementServeurVirtuelDTOPK.class)
@Table(name = "serveur_virtual_a_traitement")
public class TraitementServeurVirtuelDTO implements Serializable{

    @Id
    @Column(name="SAT_SVI_ID")
    private Integer idServeur;

    @Id
    @Column(name="SAT_RES_ID")
    private Integer idTraitement;

    @Column(name="SAT_DATE_TRAITEMENT")
    @NotNull
    private Date dateTraitement;


    @Column(name="SAT_DIND_EN_COURS")
    private int indEnCours;

    public TraitementServeurVirtuelDTO() {
    }

    public TraitementServeurVirtuelDTO(Integer idServeur, Integer idTraitement) {
        this.idServeur = idServeur;
        this.idTraitement = idTraitement;
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



}
