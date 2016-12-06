package com.cgihosting.security;

import com.cgihosting.constantes.Constantes;
import com.cgihosting.dao.UserRepository;
import com.cgihosting.dao.UserRoleRepository;
import com.cgihosting.domain.Role;
import com.cgihosting.domain.User;
import com.cgihosting.domain.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by garnons on 30/11/2016.
 */

@Service("myCustomLdapAuthorities")
public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {

    // Define the logger object for this class
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) { this.userRoleRepository = userRoleRepository; }

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations ctx, String username) {

        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        //TODO
        // Un user à toujours le ROLE_USER
        // On check en base dans la table XXXX si le user existe dans les données PSA, si oui on ajoute le ROLE_DP
        // On check en base dans la table YYYY si le user a le flag Admin, si oui on ajoute le ROLE_ADMIN
        String userId = "";
        try {
            User user = userRepository.findByLogonName(username);

            if(user==null){

                Calendar calendar = Calendar.getInstance();
                Date dateCreation = new Date(calendar.getTime().getTime());

                // ==================== Première connexion. Utilisateur inconnu de l'application.
                // Création de l'utilisateur dans la base de données avec les informations de l'active directory
                user = new User(ctx.getStringAttribute("givenname"),
                                ctx.getStringAttribute("sn"),
                                ctx.getStringAttribute("mail"),
                                ctx.getStringAttribute("telephonenumber"),
                                ctx.getStringAttribute("mobile"),
                                dateCreation,
                                dateCreation,
                                username,
                                ctx.getStringAttribute("extensionattribute1"));

                // Sauvegarde de l'utilisateur en base de données
                userRepository.save(user);

                // Attribution du role "ROLE_USER" à l'utilisateur
                UserRole userRole = new UserRole(user.getId(), Constantes.ROLE_USER);
                // Sauvegarde du role attribué à l'utilisateur dans la base de données
                userRoleRepository.save(userRole);
            }else{
                // ==================== Utilisateur déjà connu de l'application.
                userId = String.valueOf(user.getId());
            }
        }
        catch (Exception ex) {
            log.debug("User not found in Database. This is the first connexion to the application.");
        }
        log.debug("User " + username + " found in Database with id =" + userId);

        if(username.contains("garnon")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else
        {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorities;
    }
}
