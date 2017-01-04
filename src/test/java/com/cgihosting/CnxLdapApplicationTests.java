package com.cgihosting;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.domain.RoleDTO;
import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.service.admin.GererUtilisateurService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CnxLdapApplicationTests {

	@Autowired
	GererUtilisateurService gererUtilisateurService;

	@Test
	public void contextLoads() {
		Calendar calendar = Calendar.getInstance();
		Date dateCreation = new Date(calendar.getTime().getTime());

		// INSERT - tCréation d'un utilisateur sans rôle
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO("prenom", "nom", "mail", "016422", "066422", dateCreation, dateCreation, "logon", "code");
		gererUtilisateurService.saveUser(utilisateurDTO);

		// UPDATE - Mise à jour d'un utilisateur sans rôle
		utilisateurDTO.setNom("majnom");
		gererUtilisateurService.saveUser(utilisateurDTO);

		// DELETE - Suppression de l'utilisateur sans rôle
		gererUtilisateurService.deleteUser(utilisateurDTO);

		List<RoleDTO> roleDTOList = new ArrayList<>();
		roleDTOList.add(new RoleDTO(ConstantesAdmin.ROLE_USER));
		roleDTOList.add(new RoleDTO(ConstantesAdmin.ROLE_ADMIN));

		// INSERT - Création d'un utilisateur avec deux rôles
		//user = new User("prenom", "nom", "mail", "016422", "066422", dateCreation, dateCreation, "logon", "code", roleList);
		gererUtilisateurService.saveUser(utilisateurDTO);

		// DELETE - Suppression de l'utilisateur avec ses rôles
		// Ne fonctionne pas, car hibernate supprime d'abord dans la table user puis dans la table ref_role_utilisateur
		// Les contraintes d'intégritées de la BDD génèrent une exception.
		gererUtilisateurService.deleteUser(utilisateurDTO);

	}

}
