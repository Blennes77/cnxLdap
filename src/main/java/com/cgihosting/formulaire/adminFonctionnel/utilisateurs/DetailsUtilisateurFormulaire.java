package com.cgihosting.formulaire.adminFonctionnel.utilisateurs;

import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.formulaire.RacineFormulaire;

/**
 * Created by garnons on 08/12/2016.
 */
public class DetailsUtilisateurFormulaire extends RacineFormulaire {
    private UtilisateurDTO utilisateurDTO;
    private boolean roleAdmin;
    private boolean roleUser;
    private boolean roleDp;
    private boolean roleExploit;

    public UtilisateurDTO getUtilisateurDTO() {

        return utilisateurDTO;
    }

    public void setUtilisateurDTO(UtilisateurDTO utilisateurDTO) {

        this.utilisateurDTO = utilisateurDTO;
    }

    public boolean isRoleAdmin() {

        return roleAdmin;
    }

    public void setRoleAdmin(boolean roleAdmin) {

        this.roleAdmin = roleAdmin;
    }

    public boolean isRoleUser() {

        return roleUser;
    }

    public void setRoleUser(boolean roleUser) {

        this.roleUser = roleUser;
    }

    public boolean isRoleDp() {

        return roleDp;
    }

    public void setRoleDp(boolean roleDp) {

        this.roleDp = roleDp;
    }

    public boolean isRoleExploit() {
        return roleExploit;
    }

    public void setRoleExploit(boolean roleExploit) {

        this.roleExploit = roleExploit;
    }
}
