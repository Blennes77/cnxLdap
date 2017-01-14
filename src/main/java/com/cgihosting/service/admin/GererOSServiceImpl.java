package com.cgihosting.service.admin;

import com.cgihosting.domain.referentiel.ReferentielOSDTO;
import com.cgihosting.repository.ReferentielOSRepository;
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
public class GererOSServiceImpl implements GererOSService {

    /**
     * La balise autowired est indispensable
     */

    @Autowired
    private ReferentielOSRepository referentielOSRepository;

    @Override
    public List<ReferentielOSDTO> recupererReferentielOS() {

        List<ReferentielOSDTO> referentielOSDTOListe = null;

        referentielOSDTOListe = (List<ReferentielOSDTO>) referentielOSRepository.findAll();

        return referentielOSDTOListe;

    }



    @Override
    public ReferentielOSDTO recupererReferentielOSById(int identifiant) {

        ReferentielOSDTO referentielOSDTO = referentielOSRepository.findById(identifiant);

        return referentielOSDTO;
    }



    @Override
    public int modifierReferentielOS(ReferentielOSDTO referentielOSDTO) {

        referentielOSRepository.save(referentielOSDTO);

        return referentielOSDTO.getId();
    }

    public Long nombreTotalOS() {
        Long total;

        total = referentielOSRepository.count();
        return total;
    }

    @Override
    public Page<ReferentielOSDTO> searchAllReferentielOSDTOPageByPage(Integer page, Integer ligneParPage) {

        Page<ReferentielOSDTO> referentielOSDTOPage;


        referentielOSDTOPage = referentielOSRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                new Sort.Order(Sort.Direction.ASC, "nomOS")
        )));
        return referentielOSDTOPage;
    }


}
