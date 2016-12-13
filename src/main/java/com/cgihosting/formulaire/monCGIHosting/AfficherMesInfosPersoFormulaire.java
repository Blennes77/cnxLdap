package com.cgihosting.formulaire.monCGIHosting;

import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.formulaire.admin.ModeleFormulaire;

/**
 * Created by marinib on 09/12/2016.
 */
public class AfficherMesInfosPersoFormulaire extends ModeleFormulaire {

    private UtilisateurDTO utilisateurDTO;

    public UtilisateurDTO getUtilisateurDTO() {
        return utilisateurDTO;
    }

    public void setUtilisateurDTO(UtilisateurDTO utilisateurDTO) {
        this.utilisateurDTO = utilisateurDTO;
    }
}
