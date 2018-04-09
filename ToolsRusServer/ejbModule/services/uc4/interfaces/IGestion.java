package services.uc4.interfaces;

import entity.uc4.Mot;
import exception.uc4.ExistantException;

public interface IGestion {
	
	public Mot ajouter(Mot mot) throws ExistantException;
	
	public Mot update(Mot mot) throws ExistantException;

}
