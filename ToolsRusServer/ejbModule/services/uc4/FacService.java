package services.uc4;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import entity.uc4.Mot;
import exception.uc4.ExistantException;
import services.uc4.gestion.Gestion;
import services.uc4.interfaces.IGestion;

@Stateless
@Remote(IGestion.class)
public class FacService {
	
	@EJB
	Gestion serviceGestion;
	
	
	public Mot ajouter(Mot mot) throws ExistantException {
		return serviceGestion.ajouter(mot);
	}

}
