package com.cgihosting.formulaire;

import com.cgihosting.domain.User;
import com.cgihosting.service.GererRoleService;

/**
 * Created by garnons on 08/12/2016.
 */
public class DetailsUtilisateurFormulaire {
    private GererRoleService gererRoleService;
    private User user;
    private int id;

    public DetailsUtilisateurFormulaire() {
    }

    public DetailsUtilisateurFormulaire(int id, GererRoleService gererRoleService) {
        this.gererRoleService = gererRoleService;
        this.id = id;

        user = gererRoleService.searchUserById(id);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
