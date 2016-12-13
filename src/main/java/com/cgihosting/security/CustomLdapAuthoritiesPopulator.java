package com.cgihosting.security;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.repository.UserRepository;
import com.cgihosting.domain.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

/**
 * Created by garnons on 30/11/2016.
 */

@Service("myCustomLdapAuthorities")
public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {

    // Define the logger object for this class
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository; // Implémentation de l'interface via @Service et @Autowired, Spring Boot

    //public void setUserRepository(UserRepository userRepository){ this.userRepository = userRepository; }

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations ctx, String username) {

        log.debug("Entrée dans CustomLdapAuthoritiesPopulator.");

        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        //TODO COMMENTAIRES
        // Un user à toujours le ROLE_USER
        // On check en base dans la table XXXX si le user existe dans les données PSA, si oui on ajoute le ROLE_DP
        // On check en base dans la table YYYY si le user a le flag Admin, si oui on ajoute le ROLE_ADMIN
        try {
            UtilisateurDTO utilisateurDTO = userRepository.findByLogonName(username);

            if(utilisateurDTO==null){
                // ==================== Première connexion. Utilisateur inconnu de l'application.
                Calendar calendar = Calendar.getInstance();
                Date dateCreation = new Date(calendar.getTime().getTime());

                List<Role> roleList = new ArrayList<Role>();
                roleList.add(new Role(ConstantesAdmin.ROLE_USER.intValue()));

                log.debug("Création de l'utilisateur " + username + " en base de données.");

                // Création de l'utilisateur dans la base de données avec les informations de l'active directory
                utilisateurDTO = new UtilisateurDTO(ctx.getStringAttribute("givenname"),
                                ctx.getStringAttribute("sn"),
                                ctx.getStringAttribute("mail"),
                                ctx.getStringAttribute("telephonenumber"),
                                ctx.getStringAttribute("mobile"),
                                dateCreation,
                                dateCreation,
                                username,
                                ctx.getStringAttribute("extensionattribute1"), roleList);

                // Sauvegarde de l'utilisateur et du role en base de données
                userRepository.save(utilisateurDTO);

                // On recharge les données de l'utilisateur
                utilisateurDTO = userRepository.findByLogonName(username);

                // Pour supprimer dans les deux tables sauf la table de parametres
                //user.setRoleList(null);
                //userRepository.delete(user);

            }else{
                // ==================== Utilisateur déjà connu de l'application.
                // TODO NOTHING

            }

            List<Role> roleList = utilisateurDTO.getRoleList();
            if(roleList==null){
                // TODO
                log.warn("Aucun rôle en base de données associé à l'utilisateur " + username);
                authorities.add(new SimpleGrantedAuthority("ROLE_FANTOME"));
                log.warn("Association du rôle ROLE_FANTOME pour l'utilisateur " + username);
            }else{
                int size = roleList.size();
                for(int i=0;i<size;i++){
                    authorities.add(new SimpleGrantedAuthority(roleList.get(i).getLibelleRole()));
                }
            }
        }
        catch (Exception ex) {
            log.error(ex.getMessage() + " " + ex.getStackTrace());
        }
        log.debug("Sortie de CustomLdapAuthoritiesPopulator.");

        return authorities;
    }
}
