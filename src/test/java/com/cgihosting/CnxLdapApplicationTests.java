package com.cgihosting;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesDate;
import com.cgihosting.domain.ReferentielRolesDTO;
import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.outils.Dates;
import com.cgihosting.service.admin.GererUtilisateurService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CnxLdapApplicationTests {

	@Autowired
	GererUtilisateurService gererUtilisateurService;

	@Test
	public void contextLoads() {

		// INSERT - Création d'un utilisateur sans rôle
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO("prenom", "nom", "mail", "016422", "066422", Dates.aujourdhui(), Dates.aujourdhui(), "logon3", "code");
		gererUtilisateurService.saveUser(utilisateurDTO);

		// UPDATE - Mise à jour d'un utilisateur sans rôle
		utilisateurDTO.setNom("majnom");
		gererUtilisateurService.saveUser(utilisateurDTO);

		// DELETE - Suppression de l'utilisateur sans rôle
		gererUtilisateurService.deleteUser(utilisateurDTO);

		String maChaine = "";
		String maDate = "";

		maChaine = Dates.dateToString(Dates.aujourdhui(), ConstantesDate.DATE);
		maDate = Dates.dateToString(Dates.aujourdhui(), ConstantesDate.DATETIME);

		List<ReferentielRolesDTO> referentielRolesDTOList = new ArrayList<>();
		referentielRolesDTOList.add(new ReferentielRolesDTO(ConstantesAdmin.ROLE_USER));
		referentielRolesDTOList.add(new ReferentielRolesDTO(ConstantesAdmin.ROLE_ADMIN));

		// INSERT - Création d'un utilisateur avec deux rôles
		//user = new User("prenom", "nom", "mail", "016422", "066422", dateCreation, dateCreation, "logon", "code", roleList);
		gererUtilisateurService.saveUser(utilisateurDTO);

		// DELETE - Suppression de l'utilisateur avec ses rôles
		// Ne fonctionne pas, car hibernate supprime d'abord dans la table user puis dans la table ref_role_utilisateur
		// Les contraintes d'intégritées de la BDD génèrent une exception.
		gererUtilisateurService.deleteUser(utilisateurDTO);

	}

}
