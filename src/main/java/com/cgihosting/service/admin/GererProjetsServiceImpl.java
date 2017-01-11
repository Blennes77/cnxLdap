package com.cgihosting.service.admin;


import com.cgihosting.domain.ProjetDTO;
import com.cgihosting.repository.ProjetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
@Service
public class GererProjetsServiceImpl implements GererProjetsService {

    /**
     * La balise autowired est indispensable
     */
    @Autowired
    private ProjetsRepository projetsRepository;

    @Override
    public List<ProjetDTO> recupererProjets() {

        List<ProjetDTO> projetDTOListe;

        projetDTOListe =  (List<ProjetDTO>) projetsRepository.findAll();

        return projetDTOListe;

    }

    @Override
    public List<ProjetDTO> recupererProjetsDP(Integer idUser) {

        List<ProjetDTO> projetDTOListe;

        projetDTOListe =  (List<ProjetDTO>) projetsRepository.findByIdUser(idUser);

        return projetDTOListe;

    }

    public Long nombreTotalProjets() {
        Long total;

        total = projetsRepository.count();
        return total;
    }

    @Override
    public Page<ProjetDTO> searchAllProjetDTOPageByPage(Integer page, Integer ligneParPage) {

        Page<ProjetDTO> projetDTOPage;


        projetDTOPage = projetsRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                new Sort.Order(Sort.Direction.ASC, "nomProjet")
        )));
        return projetDTOPage;
    }

    @Override
    public List<ProjetDTO> searchByCodeProjet(String codeProjet) {

        List<ProjetDTO> projetDTOList;

        projetDTOList = projetsRepository.findByCodeProjetContaining(codeProjet);

        return projetDTOList;
    }
}
