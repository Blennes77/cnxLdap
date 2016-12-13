package com.cgihosting.service;

import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.repository.UserRepository;
import com.cgihosting.service.admin.GererUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by garnons on 07/12/2016.
 */

@Service("gererRoleService")
public class GererUtilsateurServiceImpl implements GererUtilisateurService {

    @Autowired
    private UserRepository userRepository;

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
        UtilisateurDTO user = userRepository.findById(id);
        return user;
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
}
