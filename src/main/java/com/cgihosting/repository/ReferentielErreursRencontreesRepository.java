package com.cgihosting.repository;

import com.cgihosting.domain.referentiel.ReferentielErreursRencontreesDTO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by marinib on 12/01/2017.
 */
public interface ReferentielErreursRencontreesRepository extends PagingAndSortingRepository<ReferentielErreursRencontreesDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */


    public ReferentielErreursRencontreesDTO findById(int identifiant);



}
