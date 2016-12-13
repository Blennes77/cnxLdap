package com.cgihosting.formulaire.admin.gererRole;

import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.formulaire.admin.ModeleFormulaire;

/**
 * Created by garnons on 08/12/2016.
 */
public class DetailsUtilisateurFormulaire extends ModeleFormulaire {
    private UtilisateurDTO utilisateurDTO;

    public UtilisateurDTO getUtilisateurDTO() {
        return utilisateurDTO;
    }

    public void setUtilisateurDTO(UtilisateurDTO utilisateurDTO) {
        this.utilisateurDTO = utilisateurDTO;
    }
}
