package services.uc4.gestion;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dao.uc4.FacDao;
import entity.uc4.Mot;
import exception.uc4.ExistantException;

@Singleton
@LocalBean
public class Gestion {
	
	@EJB private FacDao facDao;

	public Mot ajouter(Mot mot) throws ExistantException {
		facDao.add(mot);
		return mot;
	}
	
	public Mot update(Mot mot) throws ExistantException {
		facDao.update(mot);
		return mot;
	}

}
