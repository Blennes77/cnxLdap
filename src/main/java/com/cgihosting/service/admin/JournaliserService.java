package com.cgihosting.service.admin;

import com.cgihosting.domain.JournalDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */

public interface JournaliserService extends Serializable{

    List<JournalDTO> recupererJournalisation();
    void enregistrerJournalisation(JournalDTO journalDTO);


}
