package com.cgihosting.service.admin;

import com.cgihosting.domain.application.ProduitDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */

public interface GererProduitService extends Serializable{

    public List<ProduitDTO> recupererProduits();


}
