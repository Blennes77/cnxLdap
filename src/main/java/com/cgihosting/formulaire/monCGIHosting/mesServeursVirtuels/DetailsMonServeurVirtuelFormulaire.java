package com.cgihosting.formulaire.monCGIHosting.mesServeursVirtuels;

import com.cgihosting.domain.application.ServeurVirtuelDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import javax.validation.Valid;

/**
 * Created by marinib on 11/01/2017
 */
public class DetailsMonServeurVirtuelFormulaire extends RacineFormulaire {

    @Valid
    private ServeurVirtuelDTO serveurVirtuelDTO;


    public ServeurVirtuelDTO getServeurVirtuelDTO() {
        return serveurVirtuelDTO;
    }

    public void setServeurVirtuelDTO(ServeurVirtuelDTO serveurVirtuelDTO) {
        this.serveurVirtuelDTO = serveurVirtuelDTO;
    }
}
