package com.cgihosting.formulaire.monCGIHosting.mesCommandes;

import com.cgihosting.domain.application.CommandeDTO;
import com.cgihosting.formulaire.RacineFormulaire;

/**
 * Created by marinib on 06/01/2017.
 */
public class DetailsCommandeFormulaire extends RacineFormulaire {

    private CommandeDTO commandeDTO;

    public CommandeDTO getCommandeDTO() {
        return commandeDTO;
    }

    public void setCommandeDTO(CommandeDTO commandeDTO) {
        this.commandeDTO = commandeDTO;
    }
}



