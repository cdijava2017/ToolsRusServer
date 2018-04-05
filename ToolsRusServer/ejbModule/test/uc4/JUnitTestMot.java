package test.uc4;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;

import services.uc4.interfaces.IGestion;
import utils.uc4.Parametre;

public class JUnitTestMot {
	
	private static Context context;
	private static IGestion serviceFacade=null;
	
	@BeforeClass
	public static void firstOfAll() {
		
		try {
			context = new InitialContext();
			serviceFacade = (IGestion) context.lookup(Parametre.EJB_SERVICE_FACADE);
			System.out.println(serviceFacade);
		}catch (NamingException ne){
			ne.printStackTrace();
		}
	}
	
	//test ju1AddMot  TODO
	//test ju2SizeMot TODO

}
