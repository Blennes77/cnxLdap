package com.cgihosting.formulaire.monCGIHosting.mesServeursVirtuels;

import com.cgihosting.domain.ServeurVirtuelDTO;
import com.cgihosting.formulaire.admin.RacineFormulaire;

/**
 * Created by marinib on 11/01/2017
 */
public class DetailsMonServeurVirtuelFormulaire extends RacineFormulaire {

    private ServeurVirtuelDTO serveurVirtuelDTO;


    public ServeurVirtuelDTO getServeurVirtuelDTO() {
        return serveurVirtuelDTO;
    }

    public void setServeurVirtuelDTO(ServeurVirtuelDTO serveurVirtuelDTO) {
        this.serveurVirtuelDTO = serveurVirtuelDTO;
    }
}
