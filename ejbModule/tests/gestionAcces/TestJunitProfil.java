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
		System.out.println("drop");
	}

	/**
	 * 
	 */
	@Test
	// test d'ajout d'un Profil
	public void test1() {
		// User user = null;
		User user = new User(10);
		facadeService.addNewUser(user);

		Role role = new Animateur(1, "anim", true);

		Profil profil = new Profil(1, "Diagne", "Ousseynou", "climbatize.reload@gmail.com", user, role);
		facadeService.addNewProfile(profil);
		System.out.println(profil.toString());
		assertEquals("Ousseynou", facadeService.getProfil(1).getId());
		System.out.println("1 " + profil.toString());
		
	}

}
