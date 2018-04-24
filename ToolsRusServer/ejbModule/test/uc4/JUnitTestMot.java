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
import entity.uc4.MotHumeur;
import entity.uc4.Mots;
import exception.uc4.UserExistantException;
import exception.uc4.UserInexistantException;
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
	
	
	//test ju1AddMot: test to add a word in the database
	@Test
	public void ju1AddMot() throws UserExistantException, UserInexistantException {
		
		Mot testMot  = new MotHumeur (1,"super",null,2,"marvellous");
		Mot testMot2 = null;
		System.out.println("affiche mot1 " + testMot);
		
		try {
			testMot = serviceFacade.ajouter(testMot);
			System.out.println("affiche mot2 " + testMot);
			testMot2 = serviceFacade.getMot(1);
			System.out.println("affiche mot3 " + testMot2);
			
		}catch (UserExistantException ue) {
			System.out.println("dans mon existantException" + ue);
			ue.printStackTrace();
		}
		
		assertEquals("ajout d'un mot: ", 1 , testMot2.getIdMot());
		System.out.println("apres mon assertequals");
		
	}
	

	//test add a word without libelle TODO
	//test add a word already exist: must return ExistantException TODO
	
	//test delete a word existing in the database
	@Test
	public void ju1DeleteMot() throws UserInexistantException {
		
		Mot motEfface = new MotHumeur();
		
		try {
			motEfface = serviceFacade.getMot(1);
			System.out.println("ju1DeleteMot_mot efface " + motEfface);		
			serviceFacade.supprimer(motEfface);
		} catch (UserInexistantException iue) {
			iue.printStackTrace();
		}
			
		assertEquals(null, serviceFacade.getMot(1));		
	}
	
	@Test
	public void ju1ListeMot() {
		
		Mots listeMot = new Mots();
		
		 listeMot= serviceFacade.listAllMot();
		 System.out.println("ju1ListeMot_JUnitTestMot" + listeMot);
		 
		 
	}
	
}
