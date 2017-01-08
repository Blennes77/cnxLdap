package com.cgihosting.service.admin;

import com.cgihosting.domain.HebergeurDTO;
import com.cgihosting.repository.HebergeurRepository;
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
public class GererHebergeurServiceImpl implements GererHebergeurService {

    /**
     * La balise autowired est indispensable
     */
    @Autowired
    private HebergeurRepository hebergeurRepository;

    @Override
    public List<HebergeurDTO> recupererHebergeurs() {

        List<HebergeurDTO> hebergeurDTOListe = null;

        hebergeurDTOListe = (List<HebergeurDTO>) hebergeurRepository.findAll();

        return hebergeurDTOListe;

    }

    @Override
    public HebergeurDTO recupererHebergeurById(int identifiant) {

        HebergeurDTO hebergeurDTO = hebergeurRepository.findById(identifiant);

        return hebergeurDTO;
    }



    public int creerHebergeur(HebergeurDTO hebergeurDTO) {


        hebergeurRepository.save(hebergeurDTO);

        return hebergeurDTO.getId();

    }

    public Long nombreTotalHebergeurs() {
        Long total;

        total = hebergeurRepository.count();
        return total;
    }

    @Override
    public Page<HebergeurDTO> searchAllHebergeurDtoPageByPage(Integer page, Integer ligneParPage) {

        Page<HebergeurDTO> hebergeurDTOPage;


        hebergeurDTOPage = hebergeurRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                new Sort.Order(Sort.Direction.ASC, "nom")
        )));
        return hebergeurDTOPage;
    }
}
