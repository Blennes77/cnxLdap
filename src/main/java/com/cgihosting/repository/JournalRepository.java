package com.cgihosting.repository;

import com.cgihosting.domain.JournalDTO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by marinib on 09/12/2016.
 */
public interface JournalRepository extends CrudRepository<JournalDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */


}
