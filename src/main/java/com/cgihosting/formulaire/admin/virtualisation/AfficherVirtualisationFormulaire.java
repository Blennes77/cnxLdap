package com.cgihosting.formulaire.admin.virtualisation;

import com.cgihosting.domain.TypeVirtualisationDTO;
import com.cgihosting.formulaire.RacineFormulaire;
import org.springframework.data.domain.Page;

/**
 * Created by marinib on 12/01/2017.
 */
public class AfficherVirtualisationFormulaire extends RacineFormulaire {


    private Page<TypeVirtualisationDTO> typeVirtualisationDTOPage;

    public Page<TypeVirtualisationDTO> getTypeVirtualisationDTOPage() {
        return typeVirtualisationDTOPage;
    }

    public void setTypeVirtualisationDTOPage(Page<TypeVirtualisationDTO> typeVirtualisationDTOPage) {
        this.typeVirtualisationDTOPage = typeVirtualisationDTOPage;
    }
}
