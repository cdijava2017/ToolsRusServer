package clientServer.uc4;

import entity.uc4.Mot;
import exception.uc4.ExistantException;
import exception.uc4.UserExistantException;
import exception.uc4.UserInexistantException;

public interface IFacService {
	
	public Mot 	ajouter(Mot mot) 	throws UserExistantException;
	
	public Mot 	update(Mot mot) 	throws ExistantException;

	public void supprimer(Mot mot)  throws UserInexistantException;
	
	public Mot 	getMot(int idMot) 	throws UserInexistantException;

}
