package com.cgihosting.security;

import com.cgihosting.domain.application.ProjetDTO;
import com.cgihosting.domain.application.RoleUtilisateurDTO;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.repository.ProjetsRepository;
import com.cgihosting.repository.UtilisateurRepository;
import com.cgihosting.repository.UtilisateurRoleRepository;
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

import static com.cgihosting.constantes.ConstantesAdmin.*;

/**
 * Created by garnons on 30/11/2016.
 */

@Service("myCustomLdapAuthorities")
public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {

    // Define the logger object for this class
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UtilisateurRepository utilisateurRepository; // Implémentation de l'interface via @Service et @Autowired, Spring Boot

    @Autowired
    private UtilisateurRoleRepository utilisateurRoleRepository; // Implémentation de l'interface via @Service et @Autowired, Spring Boot

    @Autowired
    private ProjetsRepository projetsRepository;

    //public void setUserRepository(UserRepository userRepository){ this.userRepository = userRepository; }

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations ctx, String username) {

        log.debug("Entrée dans CustomLdapAuthoritiesPopulator.");

        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        // Un user à toujours le ROLE_USER
        // On check en base dans la table XXXX si le user existe dans les données PSA, si oui on ajoute le ROLE_DP
        try {
            // Recherce de l'utilisateur dans la table utilisateur avec le username fourni
            UtilisateurDTO utilisateurDTO = utilisateurRepository.findByLogonName(username);

            if(utilisateurDTO==null){
                // ==================== Première connexion. Utilisateur inconnu de l'application.
                Calendar calendar = Calendar.getInstance();
                Date dateCreation = new Date(calendar.getTime().getTime());

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
                                ctx.getStringAttribute("extensionattribute1"));

                // Sauvegarde de l'utilisateur
                utilisateurRepository.save(utilisateurDTO);

                // Vérification dans la table ref_projet si l'utilisateur est présent
                List<ProjetDTO> projetDTOList = new ArrayList<>();
                projetDTOList = projetsRepository.findBymailDP(utilisateurDTO.getMail());

                // Si oui, il faut lui ajouter le role ROLE_DP et ROLE_USER dans la table utilisateur_a_role
                if(projetDTOList.size()>0){
                    List<RoleUtilisateurDTO> roleUtilisateurDTOList = new ArrayList<>();
                    roleUtilisateurDTOList.add(new RoleUtilisateurDTO(utilisateurDTO.getId(), ROLE_USER));
                    roleUtilisateurDTOList.add(new RoleUtilisateurDTO(utilisateurDTO.getId(), ROLE_DP));
                    utilisateurRoleRepository.save(roleUtilisateurDTOList);

                    // On boucle maintenant sur les projets pour renseigner l'id utilisateur en regard des id projets
                    for(int i=0;i<projetDTOList.size();i++){
                        projetDTOList.get(i).setIdUser(utilisateurDTO.getId());
                    }
                    // Sauvegarde de l'utilisateur
                    projetsRepository.save(projetDTOList);
                }
                else
                {
                    // Si non, il faut ajouter uniquement le role ROLE_USER dans la table utilisateur_a_role
                    // Sauvegarde du role ROLE_USER
                    RoleUtilisateurDTO roleUtilisateurDTO = new RoleUtilisateurDTO(utilisateurDTO.getId(), ROLE_USER);
                    utilisateurRoleRepository.save(roleUtilisateurDTO);
                }

             }else{
                // ==================== Utilisateur déjà connu de l'application.
                // DO NOTHING

            }

            // Affecte les roles applicatif, au sens spring security
            List<RoleUtilisateurDTO> roleUtilisateurDTOList = utilisateurRoleRepository.findByIdUser(utilisateurDTO.getId());
            if(roleUtilisateurDTOList ==null){
                // TODO
                log.warn("Aucun rôle en base de données associé à l'utilisateur " + username);
                authorities.add(new SimpleGrantedAuthority("ROLE_FANTOME"));
                log.warn("Association du rôle ROLE_FANTOME pour l'utilisateur " + username);
            }else{
                int size = roleUtilisateurDTOList.size();
                for(int i=0;i<size;i++){

                    int idRole = roleUtilisateurDTOList.get(i).getIdRole();
                    String libelleRole = "";

                    switch (idRole) {
                        case ROLE_USER:
                            //TODO
                            libelleRole = LIBELLE_ROLE_USER;
                            break;
                        case ROLE_EXPLOITANT:
                            //TODO
                            libelleRole = LIBELLE_ROLE_EXPLOITANT;
                            break;
                        case ROLE_ADMIN:
                            //TODO
                            libelleRole = LIBELLE_ROLE_ADMIN;
                            break;
                        case ROLE_DP:
                            //TODO
                            libelleRole = LIBELLE_ROLE_DP;
                            break;
                    }
                    authorities.add(new SimpleGrantedAuthority(libelleRole));

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
