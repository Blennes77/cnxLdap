package com.cgihosting.service.admin;

import com.cgihosting.domain.JournalDTO;
import com.cgihosting.domain.TypeJournalisationDTO;
import com.cgihosting.repository.JournalRepository;
import com.cgihosting.repository.ReferentielJournalisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private ReferentielJournalisationRepository referentielJournalisationRepository;

    @Override
    public List<JournalDTO> recupererJournalisation() {

        List<JournalDTO> journalDTOListe = null;

        journalDTOListe = (List<JournalDTO>) journalRepository.findAll();

        return journalDTOListe;

    }

    @Override
    public int enregistrerJournalisation(JournalDTO journalDTO) {

        journalRepository.save(journalDTO);


        return journalDTO.getId();
    }

    @Override
    public Long nombreTotalJournalisation() {
        Long total;

        total = journalRepository.count();
        return total;
    }

    @Override
    public Page<JournalDTO> searchAllJournalDTOPageByPage(Integer page, Integer ligneParPage) {

        Page<JournalDTO> journalDTOPage;


        journalDTOPage = journalRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                new Sort.Order(Sort.Direction.ASC, "login")
        )));
        return journalDTOPage;
    }

    @Override
    public Long nombreTotalReferentielJournalisation() {
          Long total;

        total = referentielJournalisationRepository.count();
        return total;
    }

    @Override
    public Page<TypeJournalisationDTO> searchAllTypeJournalisationDTOPageByPage(Integer page, Integer ligneParPage) {
        Page<TypeJournalisationDTO> typeJournalisationDTOPage;


        typeJournalisationDTOPage = referentielJournalisationRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                new Sort.Order(Sort.Direction.ASC, "libelleAction")
        )));
        return typeJournalisationDTOPage;
    }


    @Override
    public TypeJournalisationDTO recupererReferentielJournalisationById(int identifiant) {

        TypeJournalisationDTO typeJournalisationDTO = referentielJournalisationRepository.findById(identifiant);

        return typeJournalisationDTO;
    }

    @Override
    public int creerReferentielJournalisation(TypeJournalisationDTO typeJournalisationDTO) {


        referentielJournalisationRepository.save(typeJournalisationDTO);

        return typeJournalisationDTO.getId();

    }



}
