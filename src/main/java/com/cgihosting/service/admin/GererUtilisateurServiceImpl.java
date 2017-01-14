package com.cgihosting.service.admin;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.domain.application.RoleUtilisateurDTO;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.repository.UtilisateurRepository;
import com.cgihosting.repository.UtilisateurRoleRepository;
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
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurRoleRepository utilisateurRoleRepository;

    @Override
    public UtilisateurDTO searchUserByLogonName(String username) {
        UtilisateurDTO utilisateurDTO = utilisateurRepository.findByLogonName(username);
        return utilisateurDTO;
    }

    @Override
    public int saveUser(UtilisateurDTO utilisateurDTO) {

        utilisateurRepository.save(utilisateurDTO);

        return utilisateurDTO.getId();
    }

    @Override
    public List<UtilisateurDTO> searchAllUsers() {
        List<UtilisateurDTO> userList;
        userList = (List<UtilisateurDTO>) utilisateurRepository.findAll();
        return userList;
    }

    @Override
    public UtilisateurDTO searchUserById(Integer id) {
        UtilisateurDTO utilisateurDTO = utilisateurRepository.findById(id);
        return utilisateurDTO;
    }

    @Override
    public Page<UtilisateurDTO> searchAllUsersByPage(Integer page, Integer ligneParPage) {
        Page<UtilisateurDTO> userPage;

        userPage = utilisateurRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                new Sort.Order(Sort.Direction.ASC, "nom"),
                new Sort.Order(Sort.Direction.ASC, "prenom")
        )));
        return userPage;
    }

    @Override
    public Long nombreTotalUtilisateurs(int roleUtilisateur) {
        Long total;

        total = utilisateurRepository.count();
        return total;
    }

    @Override
    public void deleteUser(UtilisateurDTO utilisateurDTO){
        utilisateurRepository.delete(utilisateurDTO);
    }

    @Override
    public Boolean mettreAJourRolesUtilisateur(int idUser, boolean roleUser, boolean roleDP, boolean roleExploit, boolean roleAdmin) {
        // Supression des rôles en base de données
        List<RoleUtilisateurDTO> listRoleUtilisateurDTO = new ArrayList<>();
        listRoleUtilisateurDTO = utilisateurRoleRepository.findByIdUser(idUser);

        utilisateurRoleRepository.delete(listRoleUtilisateurDTO);

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

        utilisateurRoleRepository.save(listRoleUtilisateurDTO);

        return true;
    }

    @Override
    public List<RoleUtilisateurDTO> recupererRolesUtilisateur(int idUser) {
        List<RoleUtilisateurDTO> listRolesUtilisateurDTO = new ArrayList<RoleUtilisateurDTO>();
        listRolesUtilisateurDTO = utilisateurRoleRepository.findByIdUser(idUser);
        return listRolesUtilisateurDTO;
    }
}


