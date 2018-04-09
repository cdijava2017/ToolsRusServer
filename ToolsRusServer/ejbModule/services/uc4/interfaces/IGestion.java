package services.uc4.interfaces;

import entity.uc4.Mot;
import exception.uc4.ExistantException;
import exception.uc4.InexistantException;

public interface IGestion {
	
	public Mot ajouter(Mot mot) throws ExistantException;
	
	public Mot update(Mot mot) throws ExistantException;
	
	public void delete(Mot mot)  throws InexistantException;
	
	public Mot getMot(int idMot) throws InexistantException;

}
