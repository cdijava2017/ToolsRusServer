package dao.uc4;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import entity.uc4.Mot;
import exception.uc4.ExistantException;

@Singleton
@LocalBean
public class FacDao {
	
	@EJB
	private DaoGestion daoGestion;
	
	public Mot add (Mot mot) throws ExistantException {
		return daoGestion.persist(mot);
	}
	
	public Mot update(Mot mot) throws ExistantException {
		return daoGestion.update(mot);
	}

	public void delete(Mot mot) {
		
	}
}
