package com.cgihosting.service.admin;

import com.cgihosting.domain.application.JournalDTO;
import com.cgihosting.domain.referentiel.ReferentielJournalisationDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */

public interface JournaliserService extends Serializable{

    public List<JournalDTO> recupererJournalisation();
    public int enregistrerJournalisation(JournalDTO journalDTO);

    public Long nombreTotalJournalisation();

    public Page<JournalDTO> searchAllJournalDTOPageByPage(Integer page, Integer ligneParPage);

    public Long nombreTotalReferentielJournalisation();

    public Page<ReferentielJournalisationDTO> searchAllReferentielJournalisationDTOPageByPage(Integer page, Integer ligneParPage);


    public ReferentielJournalisationDTO recupererReferentielJournalisationById(int identifiant);

    public  int creerReferentielJournalisation(ReferentielJournalisationDTO referentielJournalisationDTO);




}
