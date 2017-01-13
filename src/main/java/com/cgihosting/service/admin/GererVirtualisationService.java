package com.cgihosting.service.admin;

import com.cgihosting.domain.TypeVirtualisationDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib 12/01/2017.
 */

public interface GererVirtualisationService extends Serializable{

    public List<TypeVirtualisationDTO> recupererVirtualisation();

    public TypeVirtualisationDTO recupererVirtualisationById(int identifiant);


    public int modifierVirtualisation(TypeVirtualisationDTO typeVirtualisationDTO);


    public Long nombreTotalVirtualisation();

    public Page<TypeVirtualisationDTO> searchAllVirtualisationDTOPageByPage(Integer page, Integer ligneParPage);





}
