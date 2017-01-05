package com.cgihosting.service.admin;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.domain.RoleUtilisateurDTO;
import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.repository.UserRepository;
import com.cgihosting.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by garnons on 07/12/2016.
 */

@Service("gererUtilisateurService")
public class GererUtilisateurServiceImpl implements GererUtilisateurService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UtilisateurDTO searchUser(String username) {
        UtilisateurDTO utilisateurDTO = userRepository.findByLogonName(username);
        return utilisateurDTO;
    }

    @Override
    public void saveUser(UtilisateurDTO utilisateurDTO) {
        userRepository.save(utilisateurDTO);
    }

    @Override
    public List<UtilisateurDTO> searchAllUsers() {
        List<UtilisateurDTO> userList;
        userList = (List<UtilisateurDTO>) userRepository.findAll();
        return userList;
    }

    @Override
    public UtilisateurDTO searchUserById(Integer id) {
        UtilisateurDTO utilisateurDTO = userRepository.findById(id);
        return utilisateurDTO;
    }

    @Override
    public Page<UtilisateurDTO> searchAllUsersByPage(Integer page, Integer maxRow) {
        Page<UtilisateurDTO> userPage;

        userPage = userRepository.findAll(new PageRequest(page,maxRow, new Sort(
                new Sort.Order(Sort.Direction.ASC, "nom"),
                new Sort.Order(Sort.Direction.ASC, "prenom")
        )));
        return userPage;
    }

    @Override
    public Long totalUsers() {
        Long total;

        total = userRepository.count();
        return total;
    }

    @Override
    public void deleteUser(UtilisateurDTO utilisateurDTO){
        userRepository.delete(utilisateurDTO);
    }

    @Override
    public Boolean mettreAJourRolesUtilisateur(int idUser, boolean roleUser, boolean roleDP, boolean roleExploit, boolean roleAdmin) {
        // Supression des rôles en base de données
        List<RoleUtilisateurDTO> listRoleUtilisateurDTO = new ArrayList<>();
        listRoleUtilisateurDTO = userRoleRepository.findByIdUser(idUser);

        userRoleRepository.delete(listRoleUtilisateurDTO);

        // Création de la liste de rôle à insérer
        //List<RoleUtilisateurDTO> listRoleUtilisateurDTO = new ArrayList<>();
        listRoleUtilisateurDTO = new ArrayList<>();

        // Regle de gestion : un utilisateur a forcément le role ROLE_UTILISATEUR
        listRoleUtilisateurDTO.add(new RoleUtilisateurDTO(idUser, ConstantesAdmin.ROLE_USER));

        if(roleDP){
            listRoleUtilisateurDTO.add(new RoleUtilisateurDTO(idUser, ConstantesAdmin.ROLE_DP));
        }

        if(roleExploit){
            listRoleUtilisateurDTO.add(new RoleUtilisateurDTO(idUser, ConstantesAdmin.ROLE_EXPLOITANT));
        }

        if(roleAdmin){
            listRoleUtilisateurDTO.add(new RoleUtilisateurDTO(idUser, ConstantesAdmin.ROLE_ADMIN));
        }

        userRoleRepository.save(listRoleUtilisateurDTO);

        return true;
    }

    @Override
    public List<RoleUtilisateurDTO> recupererRolesUtilisateur(int idUser) {
        List<RoleUtilisateurDTO> listRolesUtilisateurDTO = new ArrayList<>();
        listRolesUtilisateurDTO = userRoleRepository.findByIdUser(idUser);
        return listRolesUtilisateurDTO;
    }
}


