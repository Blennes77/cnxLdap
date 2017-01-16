package com.cgihosting.service.admin;

import com.cgihosting.domain.application.SolutionsHebergementDTO;
import com.cgihosting.domain.referentiel.ReferentielHebergeurDTO;
import com.cgihosting.repository.ReferentielHebergeurRepository;
import com.cgihosting.repository.SolutionsHebergementRepository;
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

    @Autowired
    private SolutionsHebergementRepository  solutionsHebergementRepository;

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

    @Override
    public SolutionsHebergementDTO recupererSolutionsHebergementById(int identifiant) {
        SolutionsHebergementDTO solutionsHebergementDTO = solutionsHebergementRepository.findById(identifiant);

        return solutionsHebergementDTO;
    }

    @Override
    public int modifierSolutionsHebergement(SolutionsHebergementDTO solutionsHebergementDTO) {
        solutionsHebergementRepository.save(solutionsHebergementDTO);

        return solutionsHebergementDTO.getId();
    }

    @Override
    public Long nombreTotalSolutionshebergement() {
        Long total;

        total = solutionsHebergementRepository.count();
        return total;
    }

    @Override
    public Page<SolutionsHebergementDTO> searchAllSolutionsHebergementDtoPageByPage(Integer page, Integer ligneParPage) {
        Page<SolutionsHebergementDTO> solutionsHebergementDTOPage;


        solutionsHebergementDTOPage = solutionsHebergementRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                new Sort.Order(Sort.Direction.ASC, "libelleSolution")
        )));
        return solutionsHebergementDTOPage;
    }
}
