package clientServer.uc4;

import entity.uc4.Mot;
import exception.uc4.ExistantException;

public interface IServiceFacade {
	
	public Mot ajouter (Mot mot) throws ExistantException;

}
