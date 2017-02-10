package com.cgihosting.repository;

import com.cgihosting.domain.referentiel.ReferentielEtatCommandeDTO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by marinib on 09/0110/02
 * **/
public interface ReferentielEtatCommandeRepository extends PagingAndSortingRepository<ReferentielEtatCommandeDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */


    public ReferentielEtatCommandeDTO findById(Integer id);

}
