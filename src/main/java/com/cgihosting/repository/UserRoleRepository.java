package com.cgihosting.repository;

import com.cgihosting.domain.RoleUtilisateurDTO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by garnons on 06/12/2016.
 */
public interface UserRoleRepository extends CrudRepository<RoleUtilisateurDTO, Integer> {
}
