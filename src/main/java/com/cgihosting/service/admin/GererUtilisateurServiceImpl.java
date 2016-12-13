package com.cgihosting.service.admin;

import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by garnons on 07/12/2016.
 */

@Service("gererUtilisateurService")
public class GererUtilisateurServiceImpl implements GererUtilisateurService {

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
        List<UtilisateurDTO> utilisateurDTOListe;
        utilisateurDTOListe = (List<UtilisateurDTO>) userRepository.findAll();
        return utilisateurDTOListe;
    }

    @Override
    public UtilisateurDTO searchUserById(Integer id) {
        UtilisateurDTO utilisateurDTO = userRepository.findById(id);
        return utilisateurDTO;
    }

    @Override
    public Page<UtilisateurDTO> searchAllUsersByPage(Integer page, Integer maxRow) {
        Page<UtilisateurDTO> userPage;

        userPage = userRepository.findAll(new PageRequest(page,maxRow));
        return userPage;
    }

    @Override
    public Long totalUsers() {
        Long total;

        total = userRepository.count();
        return total;
    }
}
