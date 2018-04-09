package tests.gestionAcces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
		System.out.println("\n delete table Role\n");
	}

	/**
	 * test de supresion d'un role dans la table
	 */
	@Test
	public void delateRole() {
		Role role = new Participant(104, false);
		facadeService.addRole(role);

		assertEquals(104, facadeService.getRole(104).getId());

		facadeService.delRole(role);

	}

	/**
	 * 
	 */
	@Ignore
	// test on va s'allouer un role
	public void test1() {
		// on va creer des roles
		Role role = new Participant(1, false);
		Role role2 = new Animateur(2, true);
		Role role3 = new SuperAdmin(3,true);

		facadeService.addRole(role);
		facadeService.addRole(role2);
		facadeService.addRole(role3);
		System.out.println(
				"000 " + role.toString() + "\n" + "002 " + role2.toString() + "\n" + "006 " + role3.toString() + "\n");
		/* test des enregistrement */

		assertEquals("Griszelda", facadeService.getRole(1).getId());
		assertEquals("Moi", facadeService.getRole(2).getId());
		assertEquals(null, facadeService.getRole(3).getId());
	}

	@Test
	public void testRoleAttribuer() {
		// on va creer des roles
		Role role = new Participant(4,  false);
		Role role2 = new Animateur(5,  true);
		Role role3 = new SuperAdmin(6,true);

		// Verifier si le role fait partie de telle instance
		// assertThat(role,instanceof Role.class);

		// test si le mode admin est vrai ou pas
		/*
		 * try { assertTrue(role.isAdmin());//ko admin } catch (Exception e) {
		 * assertFalse(role.isAdmin());//ko admin }
		 */
		// ok quand il est active le mode admin
		assertFalse(role.isAdmin());// ko
		assertTrue(role2.isAdmin());// ok
		assertTrue(role3.isAdmin());// ok

		facadeService.addRole(role);
		facadeService.addRole(role2);
		facadeService.addRole(role3);

		System.out.println(
				"000 " + role.toString() + "\n" + "002 " + role2.toString() + "\n" + "006 " + role3.toString() + "\n");

	}
	
	/**
	 * apres refllexion se sont des 3 type de role donc pas besoin de les modifier
	 */
	
/* 
	@Test
	public void ModifierRole() {
		// on creer un role
		Role role = new Participant(10, false);
		facadeService.addRole(role);
		System.out.println(role.toString());

		Role role2 = new Animateur(11,true);
		facadeService.addRole(role2);
		System.out.println(role2.toString());

		// Modifier le type 	
		//role2.setId(10);
		// role2.getClass().asSubclass(Role.class). isAssignableFrom((Participant.class));
		 
		 facadeService.updRole(role2);
		
		System.out.println("update "+role.toString());
		System.out.println("update "+role2.toString());

		// assertEquals("TestMoi", facadeService.getRole(10).getNom());
		assertEquals("TestMoi", facadeService.getRole(11).getNom());

		//System.out.println(role.toString());
	//	System.out.println(role2.toString());

	}
*/
}
