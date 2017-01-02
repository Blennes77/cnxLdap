package com.cgihosting.formulaire;

import com.cgihosting.domain.User;
import com.cgihosting.service.GererRoleService;

/**
 * Created by garnons on 08/12/2016.
 */
public class DetailsUtilisateurFormulaire {
    private User user;
    private boolean roleAdmin;
    private boolean roleUser;
    private boolean roleDp;
    private boolean roleExploit;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
