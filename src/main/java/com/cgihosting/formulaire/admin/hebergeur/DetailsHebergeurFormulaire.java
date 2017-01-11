package com.cgihosting.formulaire.admin.hebergeur;

import com.cgihosting.domain.HebergeurDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import javax.validation.constraints.NotNull;

/**
 * Created by marinib on 02/01/2017
 */
public class DetailsHebergeurFormulaire extends RacineFormulaire {

    private HebergeurDTO hebergeurDTO;

    @NotNull
    private String nom;

    public HebergeurDTO getHebergeurDTO() {
        return hebergeurDTO;
    }

    public void setHebergeurDTO(HebergeurDTO hebergeurDTO) {
        this.hebergeurDTO = hebergeurDTO;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
