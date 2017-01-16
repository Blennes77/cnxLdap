package com.cgihosting.repository;

import com.cgihosting.domain.WorkflowUUIDDTO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by marinib on 09/01/2017.
 */
public interface ReferentielWorkflowsUuidRepository extends CrudRepository<WorkflowUUIDDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */


    public WorkflowUUIDDTO findByTypeEnvAndIdWorkflow (int idEnvironnement, int idNomWorkflow);


    public WorkflowUUIDDTO findById(Integer id);

}
