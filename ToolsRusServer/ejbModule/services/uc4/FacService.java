package services.uc4;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import clientServer.uc4.IFacService;
import entity.uc4.Mot;
import exception.uc4.ExistantException;
import exception.uc4.InexistantException;
import exception.uc4.UserExistantException;
import services.uc4.gestion.Gestion;


@Stateless
@Remote(IFacService.class)
public class FacService implements IFacService {
	
	@EJB
	Gestion serviceGestion;
	
	@Override
	public Mot ajouter(Mot mot) throws ExistantException, UserExistantException {
		System.out.println("FacService_ajouter  "+ mot);
		return serviceGestion.ajouter(mot);
	}
	
	@Override
	public Mot update(Mot mot) throws ExistantException {
		return serviceGestion.update(mot);
	}

	@Override
	public void delete(Mot mot) throws InexistantException{
	}

	@Override
	public Mot getMot(int idMot) throws InexistantException {
		
		return serviceGestion.getMot(idMot);
	}


}
