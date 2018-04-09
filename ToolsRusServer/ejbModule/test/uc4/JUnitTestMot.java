package test.uc4;

import static org.junit.Assert.assertEquals;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.uc4.Mot;
import exception.uc4.ExistantException;
import exception.uc4.InexistantException;
import exception.uc4.UserException;
import services.uc4.FacService;
import utils.uc4.Parametre;

public class JUnitTestMot {
	
	private static Context context;
	private static FacService serviceFacade=null;
	
	@BeforeClass
	public static void firstOfAll() {
		
		try {
			context = new InitialContext();
			serviceFacade = (FacService) context.lookup(Parametre.EJB_SERVICE_FACADE);
			//System.out.println(serviceFacade);
		}catch (NamingException ne){
			ne.printStackTrace();
		}
	}
	
	//test ju1AddMot  TODO
	@Test
	public void ju1AddMot() throws InexistantException, ExistantException, UserException {
		
		Mot testMot = new Mot (1,"super");
		Mot testMot2 = null;
		
		testMot = serviceFacade.ajouter(testMot);
		testMot2 = serviceFacade.getMot(1);
		
		assertEquals("ajout d'un mot: ", 1 , testMot2.getIdMot());
		
	}
	
	
//	@Test
//	public void r1testAjouterDocument() {
//		Document document = new Document ("001", "titre");
//		Document document2 = null;
//		try {
//			document = serviceFacade.ajouter(document);
//			// on recherche le documment 001 en base
//			document2 = serviceFacade.getDocument("001");
//		} catch (UserException e) {
//		}
//		assertEquals("ajout document : ",  "001",   document2.getCote());	
//	}
	
	//test ju2SizeMot TODO

}
