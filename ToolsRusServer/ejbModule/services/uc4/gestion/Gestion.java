package services.uc4.gestion;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dao.uc4.FacDao;
import entity.uc4.Mot;
import exception.uc4.ExistantException;
import exception.uc4.InexistantException;
import exception.uc4.UserExistantException;

@Singleton
@LocalBean
public class Gestion {
	
	@EJB private FacDao facDao;

	public Mot ajouter(Mot mot) throws UserExistantException, ExistantException {
		
		facDao.add(mot);
		System.out.println("Gestion_ajouter  "+ mot);
		return mot;
	}
	
	public Mot update(Mot mot) throws ExistantException {
		facDao.update(mot);
		return mot;
	}

	public void delete(Mot mot) throws InexistantException {
		facDao.delete(mot);
	}
	
	public Mot getMot(int idMot) throws InexistantException {
		Mot mot = null;
		mot = facDao.getMot(idMot);
		return mot;
	}
}
