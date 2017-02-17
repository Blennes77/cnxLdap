package com.cgihosting.formulaire.monCGIHosting.mesCommandes;

import com.cgihosting.domain.application.CommandeDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import java.util.List;

/**
 * Created by marinib on 06/01/2017.
 */
public class AfficherMesCommandesFormulaire extends RacineFormulaire {

    private List<CommandeDTO> commandeDTOUtilisateurDPListe;


    private List<CommandeDTO> commandeDTOUtilisateurNonDPListe;

    public List<CommandeDTO> getCommandeDTOUtilisateurDPListe() {
        return commandeDTOUtilisateurDPListe;
    }

    public void setCommandeDTOUtilisateurDPListe(List<CommandeDTO> commandeDTOUtilisateurDPListe) {
        this.commandeDTOUtilisateurDPListe = commandeDTOUtilisateurDPListe;
    }

    public List<CommandeDTO> getCommandeDTOUtilisateurNonDPListe() {
        return commandeDTOUtilisateurNonDPListe;
    }

    public void setCommandeDTOUtilisateurNonDPListe(List<CommandeDTO> commandeDTOUtilisateurNonDPListe) {
        this.commandeDTOUtilisateurNonDPListe = commandeDTOUtilisateurNonDPListe;
    }
}
