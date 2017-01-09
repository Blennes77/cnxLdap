package com.cgihosting.repository;

import com.cgihosting.domain.WorkflowNomDTO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by marinib on 09/01/2017.
 */
public interface RefWorkflowsNomRepository extends CrudRepository<WorkflowNomDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */


    public WorkflowNomDTO findByTypeHebergeurAndNomWorkflow(int idHebergeur, String nomWorkflow);


    public WorkflowNomDTO findById(Integer id);

}
