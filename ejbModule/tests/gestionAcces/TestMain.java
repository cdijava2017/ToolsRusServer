package tests.gestionAcces;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import clientServeur.IFacade;
import entity.gestionAcces.User;
import parametreGestionAcces.Parametres;

public class TestMain {

	public static void main(String[] args) {

		try {
			Context context = new InitialContext();

			IFacade serviceFacade = (IFacade) context.lookup(Parametres.EJB_SERVICE_FACADE);

			
			User user = null;

			user = new User(10, "Ousseynou", "afpapw");
			serviceFacade.addNewUser(user);
			System.out.println("ajout d'un new user");

			user.setPseudo("");
			serviceFacade.updUser(user);
			System.out.println("maj du user");	
				
			
			serviceFacade.delUserByid(10);
			System.out.println("suppr d'un user par son id");
			
			 serviceFacade.getUser(12).getPseudo();
			 
		/*	 User user3 = new User(13, "Ousseynou", "afpapw");
				serviceFacade.addNewUser(user3);
				 serviceFacade.getUser(13).getId();
			 serviceFacade.delUser(user3);*/

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}
}
