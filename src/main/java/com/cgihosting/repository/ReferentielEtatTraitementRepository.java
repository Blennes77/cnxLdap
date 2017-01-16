package com.cgihosting.repository;

import com.cgihosting.domain.referentiel.ReferentielEtatTraitementServeurDTO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by marinib on 14/01/2017.
 */
public interface ReferentielEtatTraitementRepository extends PagingAndSortingRepository<ReferentielEtatTraitementServeurDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */


    public ReferentielEtatTraitementServeurDTO findById(Integer id);

}
