package com.cgihosting.service.admin;

import com.cgihosting.domain.MessageDTO;
import com.cgihosting.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
@Service
public class MessageServiceImpl implements MessageService {

    /**
     * La balise autowired est indispensable
     */
    @Autowired
    private MessageRepository messageRepository;


    @Override
    public List<MessageDTO> recupererMessagesUtilisateur(int identifiantutilisateur) {

        List<MessageDTO> messageDTOListe = messageRepository.findByIdDest(identifiantutilisateur);


        return messageDTOListe;
    }

    @Override
    public MessageDTO recupererMessageById(int idMessage) {


        MessageDTO messageDTO = messageRepository.findById(idMessage);



                return messageDTO ;
    }


}
