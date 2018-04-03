package test.uc4;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;

import clientServer.IFacade;

public class JUnitTestMot {
	
	static Context context;
	IFacade serviceFacade;
	
	@BeforeClass
	public static void firstOfAll() {
		
		try {
			context = new InitialContext();
			//IFacade serviceFacade = (IFacade) context.lookup(null);
			
		}catch (NamingException ne){
			ne.printStackTrace();
		}
	}
	

}
