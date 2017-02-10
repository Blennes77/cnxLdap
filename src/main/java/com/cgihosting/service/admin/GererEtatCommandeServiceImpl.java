package com.cgihosting.service.admin;

import com.cgihosting.domain.referentiel.ReferentielEtatCommandeDTO;
import com.cgihosting.repository.ReferentielEtatCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by marinib on 10/02/2017.
 */
@Service
public class GererEtatCommandeServiceImpl implements GererEtatCommandeService {



    @Autowired
    private ReferentielEtatCommandeRepository referentielEtatCommandeRepository;


    @Override
    public Page<ReferentielEtatCommandeDTO>  recupererReferentielEtatCommande(Integer page, Integer ligneParPage) {

            Page<ReferentielEtatCommandeDTO> referentielEtatCommandeDTOPage = null;


        referentielEtatCommandeDTOPage = referentielEtatCommandeRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                    new Sort.Order(Sort.Direction.ASC, "id")
            )));


            return referentielEtatCommandeDTOPage;
        }

    @Override
    public Long nombreTotalReferentielEtatCommande() {
        Long total;

        total = referentielEtatCommandeRepository.count();
        return total;
    }


    @Override
    public int modifierReferentielEtatCommande(ReferentielEtatCommandeDTO referentielEtatCommandeDTO) {

        referentielEtatCommandeRepository.save(referentielEtatCommandeDTO);

        return referentielEtatCommandeDTO.getId();
    }


    @Override
    public ReferentielEtatCommandeDTO recupererReferentielEtatCommandeById(int identifiant) {

        ReferentielEtatCommandeDTO referentielEtatCommandeDTO = referentielEtatCommandeRepository.findById(identifiant);

        return referentielEtatCommandeDTO;
    }

}
