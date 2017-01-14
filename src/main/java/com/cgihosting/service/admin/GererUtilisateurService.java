package com.cgihosting.service.admin;


import com.cgihosting.domain.application.RoleUtilisateurDTO;
import com.cgihosting.domain.application.UtilisateurDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by garnons on 07/12/2016.
 */
public interface GererUtilisateurService extends Serializable{
    public UtilisateurDTO searchUserByLogonName(String username);

    public UtilisateurDTO searchUserById(Integer id);

    public int saveUser(UtilisateurDTO utilisateurDTO);

    public List<UtilisateurDTO> searchAllUsers();

    public Page<UtilisateurDTO> searchAllUsersByPage(Integer page, Integer ligneParPage);

    public Long nombreTotalUtilisateurs(int roleUtilisateur);

    public void deleteUser(UtilisateurDTO utilisateurDTO );

    public Boolean mettreAJourRolesUtilisateur(int idUser, boolean roleUser, boolean roleDP, boolean roleExploit, boolean roleAdmin);

    public List<RoleUtilisateurDTO> recupererRolesUtilisateur(int idUser);

}
