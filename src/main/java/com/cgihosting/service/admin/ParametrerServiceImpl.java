package com.cgihosting.service.admin;

import com.cgihosting.domain.ParametresAppliDTO;
import com.cgihosting.domain.ParametresVCODTO;
import com.cgihosting.repository.ParametrageAppliRepository;
import com.cgihosting.repository.ParametrageVCORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ParametresAppliDTO recupererParametresAppli() {

        List<ParametresAppliDTO> parametresAppliDTOListe = null;

        parametresAppliDTOListe = (List<ParametresAppliDTO>) parametrageAppliRepository.findAll();

        return parametresAppliDTOListe.get(0);

    }

    @Override
    public ParametresVCODTO recupererParametresVCO() {

        List<ParametresVCODTO> parametresVCODTOListe = null;

        parametresVCODTOListe = (List<ParametresVCODTO>) parametrageVCORepository.findAll();

        return parametresVCODTOListe.get(0);

    }
}
