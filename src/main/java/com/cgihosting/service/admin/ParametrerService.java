package com.cgihosting.service.admin;

import com.cgihosting.domain.application.ParametresAppliDTO;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by marinib on 09/12/2016.
 */
@Service
public interface ParametrerService extends Serializable{

    ParametresAppliDTO recupererParametresAppli(String codeEnvironnement);

    int mettreAJourParametresAppli(ParametresAppliDTO parametresAppliDTO);

}
