package com.cgihosting.service.admin;

import com.cgihosting.domain.TypeOSDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib 12/01/2017.
 */

public interface GererOSService extends Serializable{

    public List<TypeOSDTO> recupererOS();

    public TypeOSDTO recupererOSById(int identifiant);


    public int modifierOS(TypeOSDTO typeOSDTO);


    public Long nombreTotalOS();

    public Page<TypeOSDTO> searchAllOSDTOPageByPage(Integer page, Integer ligneParPage);





}
