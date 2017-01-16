package com.cgihosting.formulaire.monCGIHosting.messages;

import com.cgihosting.domain.application.MessageDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import java.util.List;

/**
 * Created by marinib on 06/01/2016.
 */
public class MessagerieFormulaire extends RacineFormulaire {

    private List<MessageDTO> messageDTOListe;


    public List<MessageDTO> getMessageDTOListe() {
        return messageDTOListe;
    }

    public void setMessageDTOListe(List<MessageDTO> messageDTOListe) {
        this.messageDTOListe = messageDTOListe;
    }
}
