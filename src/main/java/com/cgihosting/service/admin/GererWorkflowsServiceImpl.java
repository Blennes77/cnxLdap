package com.cgihosting.service.admin;

import com.cgihosting.domain.RefActionsWorkflowDTO;
import com.cgihosting.repository.RefEnvironnementRepository;
import com.cgihosting.repository.RefWorkflowsUuidRepository;
import com.cgihosting.repository.ReferentielActionsWorkflowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    private RefWorkflowsUuidRepository refWorkflowsUuidRepository;

    @Autowired
    private ReferentielActionsWorkflowsRepository referentielActionsWorkflowsRepository;


    @Autowired
    private RefEnvironnementRepository refEnvironnementRepository;


    @Override
    public Page<RefActionsWorkflowDTO>  recupererRefActionsWorkflows(Integer page, Integer ligneParPage) {

            Page<RefActionsWorkflowDTO> refActionsWorkflowDTOPage = null;

    /*
        refActionsWorkflowDTOPage = referentielActionsWorkflowsRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                    new Sort.Order(Sort.Direction.ASC, "actionWorkflow")
            )));

            */
            return refActionsWorkflowDTOPage;
        }

}
