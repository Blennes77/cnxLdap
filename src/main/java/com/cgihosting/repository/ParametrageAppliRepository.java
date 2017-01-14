package com.cgihosting.repository;

import com.cgihosting.domain.application.ParametresAppliDTO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by garnons on 02/12/2016.
 */
public interface ParametrageAppliRepository extends CrudRepository<ParametresAppliDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */

    public ParametresAppliDTO findByTypeEnvironnement(int idTypeEnvironement);


}
