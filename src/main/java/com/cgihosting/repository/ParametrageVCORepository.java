package com.cgihosting.repository;

import com.cgihosting.domain.ParametresVCODTO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by marinib on 09/12/2016.
 */
public interface ParametrageVCORepository extends CrudRepository<ParametresVCODTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */

    public ParametresVCODTO findByTypeEnvironnement(int typeEnvironnement);

}
