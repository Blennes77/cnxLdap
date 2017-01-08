package com.cgihosting.service.admin;

import com.cgihosting.domain.ParametresAppliDTO;
import com.cgihosting.domain.ParametresVCODTO;

import java.io.Serializable;

/**
 * Created by marinib on 09/12/2016.
 */

public interface ParametrerService extends Serializable{

    ParametresAppliDTO recupererParametresAppli(String codeEnvironnement);

    ParametresVCODTO recupererParametresVCO(String codeEnvironnement);


    int mettreAJourParametresAppli(ParametresAppliDTO parametresAppliDTO);
    int mettreAJourParametresVCO(ParametresVCODTO parametresVCODTO);

}
