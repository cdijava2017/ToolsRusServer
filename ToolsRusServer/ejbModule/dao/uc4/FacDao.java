package dao.uc4;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import entity.uc4.Mot;
import exception.uc4.ExistantException;
import exception.uc4.InexistantException;
import exception.uc4.UserExistantException;

@Singleton
@LocalBean
public class FacDao {
	
	@EJB
	private DaoGestion daoGestion;
	
	public Mot add (Mot mot) throws ExistantException, UserExistantException {
		try {
			daoGestion.add(mot);
			System.out.println("FacDao_add  "+ mot);
		}catch (ExistantException ee) {
			Throwable thro = ee.getCause();
				while ((thro!=null) && !(thro instanceof ExistantException)) {
					thro = thro.getCause();
				}
				if (thro instanceof ExistantException)	throw new UserExistantException();
		}
		return mot;
	}
	
	public Mot update(Mot mot) throws ExistantException {
		return daoGestion.update(mot);
	}

	public void delete(Mot mot) {
	}
	
	public Mot getMot(int idMot) throws InexistantException {
		return daoGestion.getMot(idMot);
	}
}
