package com.cgihosting.service.admin;

import com.cgihosting.domain.CommandeDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */

public interface GererCommandeService extends Serializable{

    public List<CommandeDTO> recupererCommandesUtilisateur(int identifiantUtilisateur);

    public CommandeDTO recupererCommandeById(int identifiant);




}
