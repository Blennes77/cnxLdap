package com.cgihosting.formulaire.monCGIHosting.messages;

import com.cgihosting.domain.MessageDTO;
import com.cgihosting.formulaire.RacineFormulaire;

/**
 * Created by marinib on 06/01/2016.
 */
public class DetailsMessageFormulaire extends RacineFormulaire {

    private MessageDTO messageDTO;


    public MessageDTO getMessageDTO() {
        return messageDTO;
    }

    public void setMessageDTO(MessageDTO messageDTO) {
        this.messageDTO = messageDTO;
    }
}



