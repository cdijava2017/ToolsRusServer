package dao.uc4;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import entity.uc4.Mot;

@Singleton
@LocalBean
public class DaoFacade {
	
	@EJB
	DaoGestion daoGestion;
	
	public Mot add (Mot mot) {
		return daoGestion.persist(mot);
	}
	//TODO

}
