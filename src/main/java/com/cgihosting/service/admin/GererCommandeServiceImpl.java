package com.cgihosting.service.admin;

import com.cgihosting.domain.application.CommandeDTO;
import com.cgihosting.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
@Service
public class GererCommandeServiceImpl implements GererCommandeService {

    /**
     * La balise autowired est indispensable
     */
    @Autowired
    private CommandeRepository commandeRepository;


    @Override
    public List<CommandeDTO> recupererCommandesUtilisateur(int identifiantCreateur) {


        List<CommandeDTO> commandeDTOListe = commandeRepository.findByIdCreateur(identifiantCreateur);

        return commandeDTOListe;
    }

    @Override
    public CommandeDTO recupererCommandeById(int identifiantCommande) {

        return null;
    }

}
