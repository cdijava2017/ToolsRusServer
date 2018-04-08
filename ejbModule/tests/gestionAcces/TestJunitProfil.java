package tests.gestionAcces;

import static org.junit.Assert.assertEquals;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clientServeur.IFacade;
import entity.gestionAcces.Animateur;
import entity.gestionAcces.Profil;
import entity.gestionAcces.Role;
import entity.gestionAcces.User;
import entity.uc4.Image;
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
		facadeService.removeNativeUser();
		System.out.println("Remove all table for this test");

	}

	/**
	 * 
	 */
	@Test
	// test d'ajout d'un Profil
	public void test1() {
		/*
		 * Vu en creeant un Profil, on va automatique creer l'utilisateur et son role
		 */
		User user = new User(10);
		// facadeService.addNewUser(user); //-->inutile ici

		Role role = new Animateur(1, "anim", true);
		// facadeService.addRole(role);//-->inutile ici

		Image avatar = null;
		
		Profil profil = new Profil(1, "Diagne", "Ousseynou", "climbatize.reload@gmail.com", user, role, avatar);
		facadeService.addNewProfile(profil);
		
		System.out.println(profil.toString());
		
		assertEquals("Ousseynou", facadeService.getProfil(1).getPrenom());
		
	}
	//TODO Supprimer Profil Modifier Profil son role
	//TODO VErifer Existance

}
