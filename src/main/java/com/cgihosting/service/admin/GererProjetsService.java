package com.cgihosting.service.admin;

import com.cgihosting.domain.ProjetDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib on 08/01/2017.
 */

public interface GererProjetsService extends Serializable{

    public List<ProjetDTO> recupererProjets();

    public List<ProjetDTO> recupererProjetsDP(Integer idUser);

    public Long nombreTotalProjets();

    public Page<ProjetDTO> searchAllProjetDTOPageByPage(Integer page, Integer ligneParPage);

    public List<ProjetDTO> searchByCodeProjet(String codeProjet);

}
