package services.uc4.gestion;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import dao.uc4.DaoGestion;
import entity.uc4.Mot;
import exception.uc4.ExistantException;
import services.uc4.interfaces.IGestion;

@Stateless
@Remote(IGestion.class)
public class Gestion implements IGestion {
	
	@EJB private DaoGestion daoG;

	@Override
	public Mot ajouter(Mot mot) throws ExistantException {
		daoG.persist(mot);
		return mot;
	}
	


}
