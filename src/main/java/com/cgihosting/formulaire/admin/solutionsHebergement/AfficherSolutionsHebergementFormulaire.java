package com.cgihosting.formulaire.admin.solutionsHebergement;

import com.cgihosting.domain.application.SolutionsHebergementDTO;
import com.cgihosting.formulaire.RacineFormulaire;
import org.springframework.data.domain.Page;

/**
 * Created by marinib on 09/12/2016.
 */
public class AfficherSolutionsHebergementFormulaire extends RacineFormulaire {




    private Page<SolutionsHebergementDTO> solutionsHebergementDTOPage;


    public Page<SolutionsHebergementDTO> getSolutionsHebergementDTOPage() {
        return solutionsHebergementDTOPage;
    }

    public void setSolutionsHebergementDTOPage(Page<SolutionsHebergementDTO> solutionsHebergementDTOPage) {
        this.solutionsHebergementDTOPage = solutionsHebergementDTOPage;
    }
}
