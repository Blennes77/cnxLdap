package com.cgihosting.formulaire.adminFonctionnel.parametres;

import com.cgihosting.domain.application.ParametresAppliDTO;
import com.cgihosting.formulaire.RacineFormulaire;

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