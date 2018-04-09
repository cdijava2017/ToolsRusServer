package tests.gestionAcces;

import static org.junit.Assert.assertEquals;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import clientServeur.IFacade;
import entity.gestionAcces.Animateur;
import entity.gestionAcces.Participant;
import entity.gestionAcces.Profil;
import entity.gestionAcces.Role;
import entity.gestionAcces.User;
import entity.uc4.Image;
import exception.gestionAcces.UserException;
import parametreGestionAcces.Parametres;

/***
 * Test d'un user
 * 
 * @author zinks
 *
 */
public class TestJunitProfil {

	private static IFacade facadeService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Context context = new InitialContext();
		facadeService = (IFacade) context.lookup(Parametres.EJB_SERVICE_FACADE);

	}

	@Before
	public void beforeDrop() throws Exception {
		facadeService.removeNativeProfil();
		facadeService.removeNativeUser();
		facadeService.removeNativeRole();
		System.out.println("Remove all table for this test");

	}

	/**
	 * @throws UserException
	 * 
	 */
	@Ignore
	// test d'ajout d'un Profil
	public void test1() throws UserException {
		/*
		 * Vu en creeant un Profil, on va automatique creer l'utilisateur
		 */
		User user = new User(10);
		// facadeService.addNewUser(user); //-->inutile ici
		User user2 = new User(11);

		Role role = new Animateur(1, true);
		facadeService.addRole(role);// on cree un role d'office

		Role role2 = new Participant(2, false);
		facadeService.addRole(role2);// on cree un role d'office

		Image avatar = null;

		Profil profil = new Profil(1, "Diagne", "Ousseynou", "climbatize.reload@gmail.com", user, role, avatar);
		facadeService.addNewProfile(profil);
		System.out.println(profil.toString());
		Profil profil2 = new Profil(3, "Delta", "ynou", "climbatize.reload@gmail.com", user2, role2, avatar);
		facadeService.addNewProfile(profil2);

		System.out.println(profil2.toString());

		assertEquals("Ousseynou", facadeService.getProfil(1).getPrenom());

	}

	@Test
	// Testd'ajout si id existant est modifie le role
	public void testMaj() throws UserException {
		User user = new User(20);

		Role role = new Animateur(1, true);
		facadeService.addRole(role);// on cree un role d'office

		Role role2 = new Participant(2, false);
		facadeService.addRole(role2);// on cree un role d'office

		Image avatar = null;

		Profil profil = new Profil(11, "Diagne", "Ousseynou", "climbatize.reload@gmail.com", user, role, avatar);
		facadeService.addNewProfile(profil);
		System.out.println(profil.toString());

		profil.setRole(role2);
		facadeService.updRole(role2);

		System.out.println(profil.toString());

	}

	// TODO Supprimer Profil Modifier Profil son role
	// TODO VErifer Existance

}
