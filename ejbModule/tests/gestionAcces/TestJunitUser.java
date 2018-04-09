package tests.gestionAcces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import clientServeur.IFacade;
import entity.gestionAcces.User;
import parametreGestionAcces.Parametres;
import parametreGestionAcces.UserException;

/***
 * Test d'un user
 * 
 * @author zinks
 *
 */
public class TestJunitUser {

	private static IFacade facadeService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Context context = new InitialContext();
		facadeService = (IFacade) context.lookup(Parametres.EJB_SERVICE_FACADE);

	}

	@Before
	public void beforeDrop() throws Exception {
		facadeService.removeNativeUser();
		System.out.println("drop");
	}

	@Test
	// test d'ajout d'un user
	public void test1() throws UserException {
		User user = new User(10, "Ousseynou", "afpapw");
		facadeService.addNewUser(user);
		System.out.println("Youppi");
		assertEquals("Ousseynou", facadeService.getUser(10).getPseudo());
		System.out.println("1 " + user.toString());
	}

	@Test
	// Testd'ajout si id existant est modifie
	public void testMaj() throws UserException {
		User user = new User(12, "Ousseynou", "afpapw");
		facadeService.addNewUser(user);		
		System.out.println("2 " + user.toString());
		
		User user2 = new User(15, "xxx", "afpapw");		
		facadeService.addNewUser(user2);		
		System.out.println("3 " + user2.toString());
		
		assertEquals("Ousseynou", facadeService.getUser(12).getPseudo());
		assertEquals("xxx", facadeService.getUser(15).getPseudo());
		
		user2.setId(12);
		
		facadeService.updUser(user2);
		
		System.out.println("4 " + user.toString());
		System.out.println("5 " + user2.toString());
		
		assertEquals("xxx", facadeService.getUser(12).getPseudo());
		assertEquals("xxx", facadeService.getUser(15).getPseudo());
		
		System.out.println("4bis " + user.toString());
		System.out.println("5bis " + user2.toString());
	}

	@Test
	// on cree user ,le cherche et on le delate
	public void delateUser() throws UserException {
		User user = new User(12, "Ousseynou", "afpapw");
		facadeService.addNewUser(user);

		assertEquals("Ousseynou", facadeService.getUser(12).getPseudo());

		facadeService.delUser(user);

	}
	//TODO doublon_&_null
	@Ignore
	public void AddGhostUser() throws UserException {
		User user = new User(22, null, "afpapw");
		facadeService.addNewUser(user);	
		System.out.println("user no name" + user.toString());
		assertEquals(null, facadeService.getUser(22).getPseudo());
	}
	@Ignore
	// on cree user ,on ajoute et on le rajoute
	public void AddIdemUser() throws UserException {
		User user = new User(22, "Nous", "afpapw");
		facadeService.addNewUser(user);
		facadeService.addNewUser(user);		

	}
	@Ignore
	// on chercher user non enregristtre et on le delate
	public void delateUserInexistant() throws UserException {
		User user = new User(222);
		
		facadeService.delUser(user);
		assertTrue(false);//genere erreur

	}

}
