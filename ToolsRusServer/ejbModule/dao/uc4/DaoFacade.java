package dao.uc4;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import entity.uc4.Mot;
import exception.uc4.ExistantException;

@Singleton
@LocalBean
public class DaoFacade {
	
	@EJB
	private DaoGestion daoGestion;
	
	public Mot add (Mot mot) throws ExistantException {
		return daoGestion.persist(mot);
	}
	//TODO

}
