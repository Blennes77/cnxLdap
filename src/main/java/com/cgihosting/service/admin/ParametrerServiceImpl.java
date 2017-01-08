package com.cgihosting.service.admin;

import com.cgihosting.domain.ParametresAppliDTO;
import com.cgihosting.domain.ParametresVCODTO;
import com.cgihosting.repository.ParametrageAppliRepository;
import com.cgihosting.repository.ParametrageVCORepository;
import com.cgihosting.repository.RefEnvironnementRepository;
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
    private ParametrageVCORepository parametrageVCORepository;


    @Autowired
    private RefEnvironnementRepository refEnvironnementRepository;

    @Override
    public ParametresAppliDTO recupererParametresAppli(String codeEnvironnement) {

        ParametresAppliDTO parametresAppliDTO = new ParametresAppliDTO();

        parametresAppliDTO = parametrageAppliRepository.findByTypeEnvironnement(refEnvironnementRepository.findByCodeEnvironnement(codeEnvironnement).getId());

        return parametresAppliDTO;

    }

    @Override
    public ParametresVCODTO recupererParametresVCO(String codeEnvironnement) {

        ParametresVCODTO parametresVCODTO = new ParametresVCODTO();

        parametresVCODTO = parametrageVCORepository.findByTypeEnvironnement(
                refEnvironnementRepository.findByCodeEnvironnement(codeEnvironnement).getId());


        return parametresVCODTO;

    }


    @Override
    public int mettreAJourParametresAppli(ParametresAppliDTO parametresAppliDTO) {

        parametrageAppliRepository.save(parametresAppliDTO);

        return parametresAppliDTO.getId();

    }

    @Override
    public int mettreAJourParametresVCO(ParametresVCODTO parametresVCODTO) {

        parametrageVCORepository.save(parametresVCODTO);


        return parametresVCODTO.getId();

    }
}
