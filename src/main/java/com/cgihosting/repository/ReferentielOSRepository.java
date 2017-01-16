package com.cgihosting.repository;

import com.cgihosting.domain.referentiel.ReferentielOSDTO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by marinib on 09/12/2016.
 */
public interface ReferentielOSRepository extends PagingAndSortingRepository<ReferentielOSDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */


    public ReferentielOSDTO findById(int identifiant);



}
