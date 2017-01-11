package com.cgihosting.formulaire.monCGIHosting.mesServeursVirtuels;

import com.cgihosting.domain.ServeurVirtuelDTO;
import com.cgihosting.formulaire.admin.RacineFormulaire;
import org.springframework.data.domain.Page;

/**
 * Created by marinib on 11/01/2017.
 */
public class AfficherMesServeursVirtuelsFormulaire extends RacineFormulaire {


    private Page<ServeurVirtuelDTO> serveurVirtuelDTOpage;


    public Page<ServeurVirtuelDTO> getServeurVirtuelDTOpage() {
        return serveurVirtuelDTOpage;
    }

    public void setServeurVirtuelDTOpage(Page<ServeurVirtuelDTO> serveurVirtuelDTOpage) {
        this.serveurVirtuelDTOpage = serveurVirtuelDTOpage;
    }
}
