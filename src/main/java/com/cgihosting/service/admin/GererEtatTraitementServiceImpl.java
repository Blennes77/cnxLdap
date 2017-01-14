package com.cgihosting.service.admin;

import com.cgihosting.domain.referentiel.ReferentielActionsWorkflowDTO;
import com.cgihosting.domain.referentiel.ReferentielEtatTraitementServeurDTO;
import com.cgihosting.repository.ReferentielActionsWorkflowsRepository;
import com.cgihosting.repository.ReferentielEnvironnementRepository;
import com.cgihosting.repository.ReferentielEtatTraitementRepository;
import com.cgihosting.repository.ReferentielWorkflowsUuidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by marinib on 09/01/2017.
 */
@Service
public class GererEtatTraitementServiceImpl implements GererEtatTraitementService {



    @Autowired
    private ReferentielEtatTraitementRepository referentielEtatTraitementRepository;


    @Override
    public Page<ReferentielEtatTraitementServeurDTO>  recupererReferentielEtatTraitement(Integer page, Integer ligneParPage) {

            Page<ReferentielEtatTraitementServeurDTO> referentielEtatTraitementServeurDTOPage = null;


        referentielEtatTraitementServeurDTOPage = referentielEtatTraitementRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                    new Sort.Order(Sort.Direction.ASC, "code")
            )));


            return referentielEtatTraitementServeurDTOPage;
        }

    @Override
    public Long nombreTotalReferentielEtatTraitement() {
        Long total;

        total = referentielEtatTraitementRepository.count();
        return total;
    }


    @Override
    public int modifierReferentielEtatTraitement(ReferentielEtatTraitementServeurDTO referentielEtatTraitementServeurDTO) {

        referentielEtatTraitementRepository.save(referentielEtatTraitementServeurDTO);

        return referentielEtatTraitementServeurDTO.getId();
    }


    @Override
    public ReferentielEtatTraitementServeurDTO recupererReferentielEtatTraitementById(int identifiant) {

        ReferentielEtatTraitementServeurDTO referentielEtatTraitementServeurDTO = referentielEtatTraitementRepository.findById(identifiant);

        return referentielEtatTraitementServeurDTO;
    }

}
