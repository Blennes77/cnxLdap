package com.cgihosting.service.admin;

import com.cgihosting.domain.TypeOSDTO;
import com.cgihosting.repository.ReferentielOSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marinib on 12/01/2017
 */
@Service
public class GererOSServiceImpl implements GererOSService {

    /**
     * La balise autowired est indispensable
     */

    @Autowired
    private ReferentielOSRepository referentielOSRepository;

    @Override
    public List<TypeOSDTO> recupererOS() {

        List<TypeOSDTO> typeOSDTOliste = null;

        typeOSDTOliste = (List<TypeOSDTO>) referentielOSRepository.findAll();

        return typeOSDTOliste;

    }



    @Override
    public TypeOSDTO recupererOSById(int identifiant) {

        TypeOSDTO typeOSDTO = referentielOSRepository.findById(identifiant);

        return typeOSDTO;
    }



    @Override
    public int modifierOS(TypeOSDTO typeOSDTO) {

        referentielOSRepository.save(typeOSDTO);

        return typeOSDTO.getId();
    }

    public Long nombreTotalOS() {
        Long total;

        total = referentielOSRepository.count();
        return total;
    }

    @Override
    public Page<TypeOSDTO> searchAllOSDTOPageByPage(Integer page, Integer ligneParPage) {

        Page<TypeOSDTO> typeOSDTOPage;


        typeOSDTOPage = referentielOSRepository.findAll(new PageRequest(page,ligneParPage, new Sort(
                new Sort.Order(Sort.Direction.ASC, "nomOS")
        )));
        return typeOSDTOPage;
    }


}
