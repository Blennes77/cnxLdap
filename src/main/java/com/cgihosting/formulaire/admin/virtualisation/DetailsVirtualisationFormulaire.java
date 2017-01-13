package com.cgihosting.formulaire.admin.virtualisation;

import com.cgihosting.domain.TypeVirtualisationDTO;
import com.cgihosting.formulaire.RacineFormulaire;

/**
 * Created by marinib on 12/01/2017
 */
public class DetailsVirtualisationFormulaire extends RacineFormulaire {

    private TypeVirtualisationDTO typeVirtualisationDTO;


       ;

    public TypeVirtualisationDTO getTypeVirtualisationDTO() {
        return typeVirtualisationDTO;
    }

    public void setTypeVirtualisationDTO(TypeVirtualisationDTO typeVirtualisationDTO) {
        this.typeVirtualisationDTO = typeVirtualisationDTO;
    }
}
