package com.cgihosting.service.admin;

import com.cgihosting.domain.JournalDTO;
import com.cgihosting.domain.ReferentielJournalisationDTO;
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
                new Sort.Order(Sort.Direction.ASC, "dateEvenement")
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
    public Page<ReferentielJournalisationDTO> searchAllReferentielJournalisationDTOPageByPage(Integer page, Integer ligneParPage) {
        Page<ReferentielJournalisationDTO> referentielJournalisationDTOPage;


        referentielJournalisationDTOPage = referentielJournalisationRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                new Sort.Order(Sort.Direction.ASC, "libelleAction")
        )));
        return referentielJournalisationDTOPage;
    }


    @Override
    public ReferentielJournalisationDTO recupererReferentielJournalisationById(int identifiant) {

        ReferentielJournalisationDTO referentielJournalisationDTO = referentielJournalisationRepository.findById(identifiant);

        return referentielJournalisationDTO;
    }

    @Override
    public int creerReferentielJournalisation(ReferentielJournalisationDTO referentielJournalisationDTO) {


        referentielJournalisationRepository.save(referentielJournalisationDTO);

        return referentielJournalisationDTO.getId();

    }



}
