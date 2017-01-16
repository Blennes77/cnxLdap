package com.cgihosting.service.admin;

import com.cgihosting.domain.referentiel.ReferentielActionsWorkflowDTO;
import com.cgihosting.repository.ReferentielWorkflowsUuidRepository;
import com.cgihosting.repository.ReferentielActionsWorkflowsRepository;
import com.cgihosting.repository.ReferentielEnvironnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by marinib on 09/01/2017.
 */
@Service
public class GererWorkflowsServiceImpl implements GererWorkflowsService {

    /**
     * La balise autowired est indispensable
     */
    @Autowired
    private ReferentielWorkflowsUuidRepository refWorkflowsUuidRepository;

    @Autowired
    private ReferentielActionsWorkflowsRepository referentielActionsWorkflowsRepository;


    @Autowired
    private ReferentielEnvironnementRepository referentielEnvironnementRepository;


    @Override
    public Page<ReferentielActionsWorkflowDTO>  recupererReferentielActionsWorkflows(Integer page, Integer ligneParPage) {

            Page<ReferentielActionsWorkflowDTO> referentielActionsWorkflowDTOPage = null;


        referentielActionsWorkflowDTOPage = referentielActionsWorkflowsRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                    new Sort.Order(Sort.Direction.ASC, "actionWorkflow")
            )));


            return referentielActionsWorkflowDTOPage;
        }

    @Override
    public Long nombreTotalReferentielActionsWorkflows() {
        Long total;

        total = referentielActionsWorkflowsRepository.count();
        return total;
    }


    @Override
    public int modifierReferentielActionsWorkflows(ReferentielActionsWorkflowDTO referentielActionsWorkflowDTO) {

        referentielActionsWorkflowsRepository.save(referentielActionsWorkflowDTO);

        return referentielActionsWorkflowDTO.getId();
    }


    @Override
    public ReferentielActionsWorkflowDTO recupererReferentielActionsWorkflowsById(int identifiant) {

        ReferentielActionsWorkflowDTO referentielActionsWorkflowDTO = referentielActionsWorkflowsRepository.findById(identifiant);

        return referentielActionsWorkflowDTO;
    }

}
