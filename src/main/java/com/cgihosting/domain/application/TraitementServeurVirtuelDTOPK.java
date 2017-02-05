package com.cgihosting.domain.application;


import java.io.Serializable;

public class TraitementServeurVirtuelDTOPK implements Serializable{

    private Integer idServeur;
    private Integer idTraitement;

    public TraitementServeurVirtuelDTOPK() {

    }

    public TraitementServeurVirtuelDTOPK(Integer idServeur, Integer idTraitement) {

        this.idServeur= idServeur;
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
