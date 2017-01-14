package com.cgihosting.repository;

import com.cgihosting.domain.application.CommandeDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
public interface CommandeRepository extends CrudRepository<CommandeDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */

    public List<CommandeDTO> findByIdCreateur(int idCreateur);


}
