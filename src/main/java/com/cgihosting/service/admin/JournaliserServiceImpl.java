package com.cgihosting.service.admin;

import com.cgihosting.domain.JournalDTO;
import com.cgihosting.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
@Service
public class JournaliserServiceImpl implements JournaliserService {

    /**
     * La balise autowired est indispensable
     */
    @Autowired
    private JournalRepository journalRepository;

    @Override
    public List<JournalDTO> recupererJournalisation() {

        List<JournalDTO> journalDTOListe = null;

        journalDTOListe = (List<JournalDTO>) journalRepository.findAll();

        return journalDTOListe;

    }

    @Override
    public void enregistrerJournalisation(JournalDTO journalDTO) {
        journalRepository.save(journalDTO);
    }
}
