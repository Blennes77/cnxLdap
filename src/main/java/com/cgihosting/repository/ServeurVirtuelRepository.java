package com.cgihosting.repository;

import com.cgihosting.domain.application.ServeurVirtuelDTO;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
public interface ServeurVirtuelRepository extends PagingAndSortingRepository<ServeurVirtuelDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */


    public ServeurVirtuelDTO findById(Integer id);


  //  public ServeurVirtuelDTO findByIdEnregistreurOrIdDP(Integer idEnregistreur, Integer idDP);

    public List<ServeurVirtuelDTO> findByIdProjet(Integer idprojet);

}
