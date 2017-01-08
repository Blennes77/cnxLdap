package com.cgihosting.repository;

import com.cgihosting.domain.TemplateOSDTO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by marinib on 07/01/2016.
 */
public interface TemplateOSRepository extends PagingAndSortingRepository<TemplateOSDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */


    public TemplateOSDTO findById(Integer id);

}
