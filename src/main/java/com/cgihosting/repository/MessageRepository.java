package com.cgihosting.repository;

import com.cgihosting.domain.MessageDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by garnons on 02/12/2016.
 */
public interface MessageRepository extends CrudRepository<MessageDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */

    public List<MessageDTO> findByIdDest(int idUser);

    public MessageDTO findById(int idMessage);


}
