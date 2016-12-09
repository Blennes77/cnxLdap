package com.cgihosting.repository;

import com.cgihosting.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by garnons on 02/12/2016.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */
    //public User findByA_uti_mail(String a_uti_mail);

    //public User findUserByIdenti(String identi);
    public User findByLogonName(String logonName);
    public User findById(Integer id);
}
