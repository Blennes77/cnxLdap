package com.cgihosting.repository;

import com.cgihosting.domain.application.ProjetDTO;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by marinib on 08/01/2017.
 */
public interface ProjetsRepository extends PagingAndSortingRepository<ProjetDTO, Integer> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */


    public ProjetDTO findById(Integer id);

    public List<ProjetDTO> findByIdUser(Integer idUser);

    public List<ProjetDTO> findByMailDP(String mail);

    public List<ProjetDTO> findByCodeProjetContaining(String codeProjet);

}
