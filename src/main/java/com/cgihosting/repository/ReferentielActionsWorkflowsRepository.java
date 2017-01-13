package com.cgihosting.repository;

import com.cgihosting.domain.RefActionsWorkflowDTO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by marinib on 09/01/2017.
 */
public interface ReferentielActionsWorkflowsRepository extends CrudRepository<RefActionsWorkflowDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */


    public RefActionsWorkflowDTO findById(Integer id);

}
