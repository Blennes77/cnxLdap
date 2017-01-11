package com.cgihosting.formulaire.admin.parametres;

import com.cgihosting.domain.ParametresVCODTO;
import com.cgihosting.formulaire.RacineFormulaire;

/**
 * Created by marinib on 09/12/2016.
 */
public class ParametrerVCOFormulaire extends RacineFormulaire {

    private ParametresVCODTO parametresVCODTO ;


    public ParametresVCODTO getParametresVCODTO() {
        return parametresVCODTO;
    }

    public void setParametresVCODTO(ParametresVCODTO parametresVCODTO) {
        this.parametresVCODTO = parametresVCODTO;
    }
}
