package com.cgihosting.service.admin;


import com.cgihosting.domain.application.ProduitDTO;
import com.cgihosting.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
@Service
public class GererProduitServiceImpl implements GererProduitService {

    /**
     * La balise autowired est indispensable
     */
    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public List<ProduitDTO> recupererProduits() {

        List<ProduitDTO> produitDTOListe;

        produitDTOListe =  (List<ProduitDTO>) produitRepository.findAll();

        return produitDTOListe;

    }
}
