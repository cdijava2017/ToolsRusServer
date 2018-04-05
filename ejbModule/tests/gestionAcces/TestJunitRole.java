package tests.gestionAcces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clientServeur.IFacade;
import entity.gestionAcces.Animateur;
import entity.gestionAcces.Participant;
import entity.gestionAcces.Role;
import entity.gestionAcces.SuperAdmin;
import parametreGestionAcces.Parametres;

/***
 * Test d'un user
 * 
 * @author zinks
 *
 */
public class TestJunitRole {

	private static IFacade facadeService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Context context = new InitialContext();
		facadeService = (IFacade) context.lookup(Parametres.EJB_SERVICE_FACADE);

	}

	@Before
	public void beforeDrop() throws Exception {
		facadeService.removeNativeRole();
		System.out.println("delete table Role");
	}

	/**
	 * 
	 */
	@Test
	// test on va s'allouer un role
	public void test1() {
		// on va creer des roles
		Role role = new Participant(1, "Griszelda", false);
		Role role2 = new Animateur(2, "Moi", true);
		Role role3 = new SuperAdmin(3, null, true);

		facadeService.addRole(role);
		facadeService.addRole(role2);
		facadeService.addRole(role3);
		System.out.println(
				"000 " + role.toString() + "\n" + "002 " + role2.toString() + "\n" + "006 " + role3.toString() + "\n");
		/* test des enregistrement */

		assertEquals("Griszelda", facadeService.getRole(1).getNom());
		assertEquals("Moi", facadeService.getRole(2).getNom());
		assertEquals(null, facadeService.getRole(3).getNom());
	}

	@Test
	public void testRoleAttribuer() {
		// on va creer des roles
		Role role = new Participant(4, "Toi", false);
		Role role2 = new Animateur(5, "Moi", true);
		Role role3 = new SuperAdmin(6, "vous", true);

		// Verifier si le role fait partie de telle instance
		// assertTrue(role,is((Role.class)));
		
		// test si le mode admin est vrai ou pas
		/* try { assertTrue(role.isAdmin());//ko admin } catch (Exception e) {
		 * assertFalse(role.isAdmin());//ko admin }
		 */
		assertFalse(role.isAdmin());// ko admin
		assertTrue(role2.isAdmin());// ok admin
		assertTrue(role3.isAdmin());// ok admin

		facadeService.addRole(role);
		facadeService.addRole(role2);
		facadeService.addRole(role3);

		System.out.println(
				"000 " + role.toString() + "\n" + "002 " + role2.toString() + "\n" + "006 " + role3.toString() + "\n");

	}

}
