package com.cgihosting.service.admin;

import com.cgihosting.domain.application.ParametresAppliDTO;
import com.cgihosting.repository.ParametrageAppliRepository;
import com.cgihosting.repository.ReferentielEnvironnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by marinib on 09/12/2016.
 */
@Service
public class ParametrerServiceImpl implements ParametrerService {

    /**
     * La balise autowired est indispensable
     */
    @Autowired
    private ParametrageAppliRepository parametrageAppliRepository;


    @Autowired
    private ReferentielEnvironnementRepository referentielEnvironnementRepository;

    @Override
    public ParametresAppliDTO recupererParametresAppli(String codeEnvironnement) {

        ParametresAppliDTO parametresAppliDTO = new ParametresAppliDTO();

        parametresAppliDTO = parametrageAppliRepository.findByTypeEnvironnement(referentielEnvironnementRepository.findByCodeEnvironnement(codeEnvironnement).getId());

        return parametresAppliDTO;

    }



    @Override
    public int mettreAJourParametresAppli(ParametresAppliDTO parametresAppliDTO) {

        parametrageAppliRepository.save(parametresAppliDTO);

        return parametresAppliDTO.getId();

    }


}
