package com.cgihosting.service.admin;

import com.cgihosting.domain.ProduitDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */

public interface GererProduitService extends Serializable{

    List<ProduitDTO> recupererProduits();


}