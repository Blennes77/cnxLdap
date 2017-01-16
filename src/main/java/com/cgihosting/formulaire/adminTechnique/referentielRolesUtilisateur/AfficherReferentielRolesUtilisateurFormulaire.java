package com.cgihosting.formulaire.adminTechnique.referentielRolesUtilisateur;

import com.cgihosting.domain.referentiel.ReferentielRolesDTO;
import com.cgihosting.formulaire.RacineFormulaire;
import org.springframework.data.domain.Page;

/**
 * Created by marinib on 16/01/2017.
 */
public class AfficherReferentielRolesUtilisateurFormulaire extends RacineFormulaire {


    Page<ReferentielRolesDTO> referentielRolesDTOPage;


    public Page<ReferentielRolesDTO> getReferentielRolesDTOPage() {
        return referentielRolesDTOPage;
    }

    public void setReferentielRolesDTOPage(Page<ReferentielRolesDTO> referentielRolesDTOPage) {
        this.referentielRolesDTOPage = referentielRolesDTOPage;
    }
}
