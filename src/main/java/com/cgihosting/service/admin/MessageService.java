package com.cgihosting.service.admin;

import com.cgihosting.domain.application.MessageDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */

public interface MessageService extends Serializable{

    public List<MessageDTO> recupererMessagesUtilisateur(int identifiantutilisateur);


    public MessageDTO recupererMessageById(int identifiantMessage);


}
