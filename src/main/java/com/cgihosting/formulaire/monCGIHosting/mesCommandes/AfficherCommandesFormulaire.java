package com.cgihosting.formulaire.monCGIHosting.mesCommandes;

import com.cgihosting.domain.CommandeDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import java.util.List;

/**
 * Created by marinib on 06/01/2017.
 */
public class AfficherCommandesFormulaire extends RacineFormulaire {

    private List<CommandeDTO> commandeDTOListe;


    public List<CommandeDTO> getCommandeDTOListe() {
        return commandeDTOListe;
    }

    public void setCommandeDTOListe(List<CommandeDTO> commandeDTOListe) {
        this.commandeDTOListe = commandeDTOListe;
    }
}
