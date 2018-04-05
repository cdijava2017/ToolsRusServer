package tests.gestionAcces;

import static org.junit.Assert.assertEquals;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clientServeur.IFacade;
import entity.gestionAcces.User;
import parametreGestionAcces.Parametres;

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
	public void test1() {
		User user = new User(10, "Ousseynou", "afpapw");
		facadeService.addNewUser(user);
		System.out.println("Youppi");
		assertEquals("Ousseynou", facadeService.getUser(10).getPseudo());
		System.out.println("1 " + user.toString());
	}

	@Test
	// Testd'ajout si id existant est modifie
	public void testMaj() {
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
	public void delateUser() {
		User user = new User(12, "Ousseynou", "afpapw");
		facadeService.addNewUser(user);

		assertEquals("Ousseynou", facadeService.getUser(12).getPseudo());

		facadeService.delUser(user);

	}
	//TODO doublon_&_null

}
