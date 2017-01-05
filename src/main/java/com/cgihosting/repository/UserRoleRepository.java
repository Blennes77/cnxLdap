package com.cgihosting.repository;

import com.cgihosting.domain.RoleUtilisateurDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by garnons on 06/12/2016.
 */
public interface UserRoleRepository extends CrudRepository<RoleUtilisateurDTO, Integer> {

    public List<RoleUtilisateurDTO> findByIdUser(Integer id) ;

    public void deleteByIdUser(Integer id);

}
