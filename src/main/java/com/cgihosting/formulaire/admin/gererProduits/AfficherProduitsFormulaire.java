package com.cgihosting.formulaire.admin.gererProduits;

import com.cgihosting.domain.ProduitDTO;
import com.cgihosting.formulaire.admin.ModeleFormulaire;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
public class AfficherProduitsFormulaire extends ModeleFormulaire {

    private List<ProduitDTO> produitDTOListe ;

    public List<ProduitDTO> getProduitDTOListe() {
        return produitDTOListe;
    }

    public void setProduitDTOListe(List<ProduitDTO> produitDTOListe) {
        this.produitDTOListe = produitDTOListe;
    }
}
