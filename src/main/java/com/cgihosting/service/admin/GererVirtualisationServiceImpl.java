package com.cgihosting.service.admin;

import com.cgihosting.domain.TypeVirtualisationDTO;
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
    public List<TypeVirtualisationDTO> recupererVirtualisation() {

        List<TypeVirtualisationDTO> typeVirtualisationDTOListe = null;

        typeVirtualisationDTOListe = (List<TypeVirtualisationDTO>) referentielVirtualisationRepository.findAll();

        return typeVirtualisationDTOListe;

    }



    @Override
    public TypeVirtualisationDTO recupererVirtualisationById(int identifiant) {

        TypeVirtualisationDTO typeVirtualisationDTO = referentielVirtualisationRepository.findById(identifiant);

        return typeVirtualisationDTO;
    }



    @Override
    public int modifierVirtualisation(TypeVirtualisationDTO typeVirtualisationDTO) {

        referentielVirtualisationRepository.save(typeVirtualisationDTO);

        return typeVirtualisationDTO.getId();
    }

    public Long nombreTotalVirtualisation() {
        Long total;

        total = referentielVirtualisationRepository.count();
        return total;
    }

    @Override
    public Page<TypeVirtualisationDTO> searchAllVirtualisationDTOPageByPage(Integer page, Integer ligneParPage) {

        Page<TypeVirtualisationDTO> typeVirtualisationDTOPage;


        typeVirtualisationDTOPage = referentielVirtualisationRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                new Sort.Order(Sort.Direction.ASC, "nomVirtualisation")
        )));
        return typeVirtualisationDTOPage;
    }


}
