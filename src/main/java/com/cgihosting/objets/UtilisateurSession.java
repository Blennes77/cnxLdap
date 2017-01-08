package com.cgihosting.objets;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by marinib on 07/01/2017.
 */
public class UtilisateurSession {

    private static String login;


    public static String getLogin() {



        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            login = ((UserDetails)principal).getUsername();
        } else {
            login = principal.toString();
        }


        return login;
    }

}
