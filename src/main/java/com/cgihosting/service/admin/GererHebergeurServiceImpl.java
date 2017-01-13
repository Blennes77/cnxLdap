package com.cgihosting.service.admin;

import com.cgihosting.domain.ReferentielHebergeurDTO;
import com.cgihosting.repository.ReferentielHebergeurRepository;
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
    private ReferentielHebergeurRepository hebergeurRepository;

    @Override
    public List<ReferentielHebergeurDTO> recupererReferentielHebergeurs() {

        List<ReferentielHebergeurDTO> referentielHebergeurDTOListe = null;

        referentielHebergeurDTOListe = (List<ReferentielHebergeurDTO>) hebergeurRepository.findAll();

        return referentielHebergeurDTOListe;

    }

    @Override
    public ReferentielHebergeurDTO recupererHebergeurById(int identifiant) {

        ReferentielHebergeurDTO ReferentielHebergeurDTO = hebergeurRepository.findById(identifiant);

        return ReferentielHebergeurDTO;
    }



    public int creerReferentielHebergeur(ReferentielHebergeurDTO referentielHebergeurDTO) {


        hebergeurRepository.save(referentielHebergeurDTO);

        return referentielHebergeurDTO.getId();

    }

    public Long nombreTotalReferentielHebergeurs() {
        Long total;

        total = hebergeurRepository.count();
        return total;
    }

    @Override
    public Page<ReferentielHebergeurDTO> searchAllReferentielHebergeurDtoPageByPage(Integer page, Integer ligneParPage) {

        Page<ReferentielHebergeurDTO> referentielHebergeurDTOPage;


        referentielHebergeurDTOPage = hebergeurRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                new Sort.Order(Sort.Direction.ASC, "nom")
        )));
        return referentielHebergeurDTOPage;
    }
}
