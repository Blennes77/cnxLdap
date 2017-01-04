package com.cgihosting.service.admin;


import com.cgihosting.domain.UtilisateurDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by garnons on 07/12/2016.
 */
public interface GererUtilisateurService extends Serializable{
    public UtilisateurDTO searchUser(String username);

    public UtilisateurDTO searchUserById(Integer id);

    public void saveUser(UtilisateurDTO utilisateurDTO);

    public List<UtilisateurDTO> searchAllUsers();

    public Page<UtilisateurDTO> searchAllUsersByPage(Integer page, Integer ligneParPage);

    public Long totalUsers();

    public void deleteUser(UtilisateurDTO utilisateurDTO );
}
