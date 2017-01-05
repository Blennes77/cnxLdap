package com.cgihosting.controller.admin;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.formulaire.admin.gererRole.AfficherUtilisateursFormulaire;
import com.cgihosting.formulaire.admin.gererRole.DetailsUtilisateurFormulaire;
import com.cgihosting.repository.UserRoleRepository;
import com.cgihosting.service.admin.GererUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by garnons on 07/12/2016.
 */
@Controller
public class UtilisateursController {
    @Autowired
    private GererUtilisateurService gererUtilisateurService;
    @Autowired
    private UserRoleRepository userRoleRepository;

    private AfficherUtilisateursFormulaire afficherUtilisateursFormulaire;
    private DetailsUtilisateurFormulaire detailsUtilisateurFormulaire;

    @RequestMapping(value = "/admin/afficherUtilisateurs", method = RequestMethod.GET)
    String afficherUtilisateurs(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,
                                Model model)
    {

        //BEST CODE: model.addAttribute("formulaire", recupererFormulaireAfficherUtilisateurs(page, ligneParPage));
        recupererFormulaireAfficherUtilisateurs(page, ligneParPage);
        model.addAttribute("formulaire", afficherUtilisateursFormulaire);
        return "admin/utilisateurs/afficherUtilisateurs";
    }

    @RequestMapping(value = "/admin/afficherDetailsUtilisateur", method = RequestMethod.GET)
    String detailsUtilisateur(@RequestParam("id") int id, Model model){

        recupererFormulaireDetailsUtilisateur(id);
        model.addAttribute("formulaire", detailsUtilisateurFormulaire);
        return "admin/utilisateurs/detailsUtilisateur";
    }

    @RequestMapping(value = "/admin/modifierDetailsUtilisateur", method = RequestMethod.POST)
    String submitRole(int id, boolean roleUser, boolean roleDP, boolean roleExploit, boolean roleAdmin, String action){

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {



        }
        else {


        }

        //TODO
        //UserRole roles = userRoleRepository.findByIdUser(id);
/**
 User user = gererRoleService.searchUserById(id);
 List<Role> roleList = user.getRoleList();
 roleList.add(new Role(Constantes.ROLE_DP));
 user.setRoleList(roleList);
 gererRoleService.saveUser(user);
 **/
        return "redirect:/admin/afficherUtilisateurs";
    }

    ////BEST CODE: private AfficherUtilisateursFormulaire recupererFormulaireAfficherUtilisateurs(int page, int ligneParPage){
    private void recupererFormulaireAfficherUtilisateurs(int page, int ligneParPage){

        Long numTotalUsers;
        int numLigneAfficheParPage;


        // Création du formulaire afficherUtilisateurFormulaire
        // page : affiche la page demandé si le nombre d'utilisateurs ramenés est trop conséquent
        // ligneParPage : définie le nombre d'utilisateur que l'on affiche sur chaque page
        // gererRoleService : référence du bean GererRoleService
        //BEST CODE: AfficherUtilisateursFormulaire afficherUtilisateursFormulaire = new AfficherUtilisateursFormulaire(page, ligneParPage, gererRoleService);

        // Désolé, ce n'est vraiment pas beau mais j'ai du faire comme ca parce que c'est Baptiste qui le veut.
        // Je le suspecte d'être un psycho rigide des getter et setter.....
        // Tout ce code merdique peut être remplacé par un zolie constructeur que j'ai conservé dans AfficherUtilisateursFormulaire
        afficherUtilisateursFormulaire = new AfficherUtilisateursFormulaire();
        afficherUtilisateursFormulaire.setNumTotalUsers(gererUtilisateurService.totalUsers());
        afficherUtilisateursFormulaire.setNumPageCourante(page);
        afficherUtilisateursFormulaire.setNbLigneAfficheParPage(ligneParPage);
        numTotalUsers = afficherUtilisateursFormulaire.getNumTotalUsers();
        numLigneAfficheParPage = afficherUtilisateursFormulaire.getNbLigneAfficheParPage();
        afficherUtilisateursFormulaire.setNumPageTotal((int) Math.ceil((double) numTotalUsers / (double) numLigneAfficheParPage));

        //TODO : Recherche des utilisateurs en fonction de la page et du nombre de ligne par page
        afficherUtilisateursFormulaire.setUtilisateurDTOPage(gererUtilisateurService.searchAllUsersByPage(page, ligneParPage));
        //BEST CODE: return afficherUtilisateursFormulaire;
    }

    private void recupererFormulaireDetailsUtilisateur(int id){
        UtilisateurDTO utilisateurDTO;
        //List<Role> roleList;

        //roleList = new ArrayList<Role>();

        detailsUtilisateurFormulaire = new DetailsUtilisateurFormulaire();
        detailsUtilisateurFormulaire.setUtilisateurDTO(gererUtilisateurService.searchUserById(id));

        detailsUtilisateurFormulaire.setBoutonSoumissionLabel(ConstantesPage.BOUTON_MODIFIER_ROLE_UTILISATEUR);
        detailsUtilisateurFormulaire.setBoutonRetourLabel(ConstantesPage.BOUTON_RETOUR_AFFICHER_UTILISATEURS);

        utilisateurDTO = detailsUtilisateurFormulaire.getUtilisateurDTO();
        /**
         roleList = user.getRoleList();

         ListIterator<Role> roleListIterator = roleList.listIterator();
         while(roleListIterator.hasNext()){
         Role role = roleListIterator.next();
         switch (role.getId()) {
         case ROLE_USER:
         //TODO
         detailsUtilisateurFormulaire.setRoleUser(true);
         break;
         case ROLE_EXPLOITANT:
         //TODO
         detailsUtilisateurFormulaire.setRoleExploit(true);
         break;
         case ROLE_ADMIN:
         //TODO
         detailsUtilisateurFormulaire.setRoleAdmin(true);
         break;
         }
         }**/
    }
}



