package com.cgihosting.service.admin;

import com.cgihosting.domain.ReferentielVirtualisationDTO;
import com.cgihosting.repository.ReferentielVirtualisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marinib on 12/01/2017
 */
@Service
public class GererVirtualisationServiceImpl implements GererVirtualisationService {

    /**
     * La balise autowired est indispensable
     */

    @Autowired
    private ReferentielVirtualisationRepository referentielVirtualisationRepository;

    @Override
    public List<ReferentielVirtualisationDTO> recupererReferentielVirtualisation() {

        List<ReferentielVirtualisationDTO> referentielVirtualisationDTOListe = null;

        referentielVirtualisationDTOListe = (List<ReferentielVirtualisationDTO>) referentielVirtualisationRepository.findAll();

        return referentielVirtualisationDTOListe;

    }



    @Override
    public ReferentielVirtualisationDTO recupererReferentielVirtualisationById(int identifiant) {

        ReferentielVirtualisationDTO referentielVirtualisationDTO = referentielVirtualisationRepository.findById(identifiant);

        return referentielVirtualisationDTO;
    }



    @Override
    public int modifierReferentielVirtualisation(ReferentielVirtualisationDTO referentielVirtualisationDTO) {

        referentielVirtualisationRepository.save(referentielVirtualisationDTO);

        return referentielVirtualisationDTO.getId();
    }

    public Long nombreTotalVirtualisation() {
        Long total;

        total = referentielVirtualisationRepository.count();
        return total;
    }

    @Override
    public Page<ReferentielVirtualisationDTO> searchAllReferentielVirtualisationDTOPageByPage(Integer page, Integer ligneParPage) {

        Page<ReferentielVirtualisationDTO> referentielVirtualisationDTOPage;


        referentielVirtualisationDTOPage = referentielVirtualisationRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                new Sort.Order(Sort.Direction.ASC, "nomVirtualisation")
        )));
        return referentielVirtualisationDTOPage;
    }


}
