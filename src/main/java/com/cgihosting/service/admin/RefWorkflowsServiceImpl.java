package com.cgihosting.service.admin;

import com.cgihosting.domain.WorkflowNomDTO;
import com.cgihosting.domain.WorkflowUUIDDTO;
import com.cgihosting.repository.RefEnvironnementRepository;
import com.cgihosting.repository.RefWorkflowsNomRepository;
import com.cgihosting.repository.RefWorkflowsUuidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by marinib on 09/01/2017.
 */
@Service
public class RefWorkflowsServiceImpl implements RefWorkflowsService {

    /**
     * La balise autowired est indispensable
     */
    @Autowired
    private RefWorkflowsUuidRepository refWorkflowsUuidRepository;

    @Autowired
    private RefWorkflowsNomRepository refWorkflowsNomRepository;


    @Autowired
    private RefEnvironnementRepository refEnvironnementRepository;

    @Override
    public WorkflowUUIDDTO recupererRefWorkflowsUuiDTO(String codeEnvironnement, String nomWorkflow, int idhebergeur) {

        WorkflowNomDTO workflowNomDTO = refWorkflowsNomRepository.findByTypeHebergeurAndNomWorkflow(idhebergeur,
                                                                                                    nomWorkflow);


        WorkflowUUIDDTO workflowUUIDDTO = refWorkflowsUuidRepository.findByTypeEnvAndIdWorkflow(
                                                    refEnvironnementRepository.findByCodeEnvironnement(
                                                        codeEnvironnement).getId(),
                                                    workflowNomDTO.getId());

        return workflowUUIDDTO;

    }

}
