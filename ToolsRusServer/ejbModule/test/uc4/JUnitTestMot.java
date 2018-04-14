package test.uc4;

import static org.junit.Assert.assertEquals;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clientServer.uc4.IFacService;
import entity.uc4.Mot;
import exception.uc4.InexistantException;
import exception.uc4.UserExistantException;
import utils.uc4.Parametre;

public class JUnitTestMot {
	
	private static Context context;
	private static IFacService serviceFacade;
	
	@BeforeClass
	public static void firstOfAll() {
		
		try {
			context = new InitialContext();
			//System.out.println("JUnitTestMot_firstofall_avant service facade");
			serviceFacade = (IFacService) context.lookup(Parametre.EJB_SERVICE_FACADE);
			//System.out.println("JUnitTestMot_firstofall_apres service facade " +serviceFacade);
		}catch (NamingException ne){
			ne.printStackTrace();
		}
	}
	
	@Before
	public void justBefore() {
		System.out.println("Appel de la methode justBefore() de la classe de test");
		
		try { 
			context= new InitialContext();
			serviceFacade = (IFacService) context.lookup(Parametre.EJB_SERVICE_FACADE);
			
		}catch (NamingException ne) {
			ne.printStackTrace();
		}
	}
	
	
	//test ju1AddMot
	@Test
	public void ju1AddMot() throws UserExistantException, InexistantException {
		
		Mot testMot  = new Mot (1,"super");
		Mot testMot2 = null;
		System.out.println("affiche mot1 " + testMot);
		
		try {
			testMot = serviceFacade.ajouter(testMot);
			System.out.println("affiche mot2 " + testMot);
			testMot2 = serviceFacade.getMot(1);
			System.out.println("affiche mot3 " + testMot2);
			
		}catch (UserExistantException ue) {
			System.out.println("dans mon existantException" + ue);
		}
		
		assertEquals("ajout d'un mot: ", 1 , testMot2.getIdMot());
		System.out.println("apres mon assertequals");
		
	}
	

	//test add a word without libelle TODO
	//test add a word already exist: must return ExistantException
}
