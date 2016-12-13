package com.cgihosting.service.admin;

import com.cgihosting.domain.HebergeurDTO;
import com.cgihosting.repository.HebergeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
@Service
public class GererHebergeurServiceImpl implements GererHebergeurService {

    /**
     * La balise autowired est indispensable
     */
    @Autowired
    private HebergeurRepository hebergeurRepository;

    @Override
    public List<HebergeurDTO> recupererHebergeurs() {

        List<HebergeurDTO> hebergeurDTOListe = null;

        hebergeurDTOListe = (List<HebergeurDTO>) hebergeurRepository.findAll();

        return hebergeurDTOListe;

    }
}
