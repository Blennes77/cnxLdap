package com.cgihosting.formulaire.admin.parametres;

import com.cgihosting.domain.ParametresAppliDTO;
import com.cgihosting.formulaire.admin.RacineFormulaire;

/**
 * Created by marinib on 09/12/2016.
 */
public class ParametrerAppliFormulaire extends RacineFormulaire {


    private ParametresAppliDTO parametresAppliDTO;

    public ParametresAppliDTO getParametresAppliDTO() {
        return parametresAppliDTO;
    }

    public void setParametresAppliDTO(ParametresAppliDTO parametresAppliDTO) {
        this.parametresAppliDTO = parametresAppliDTO;
    }
}
