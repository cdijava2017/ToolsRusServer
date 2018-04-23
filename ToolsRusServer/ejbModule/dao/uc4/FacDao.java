package dao.uc4;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import entity.uc4.Mot;
import entity.uc4.Mots;
import exception.uc4.ExistantException;
import exception.uc4.InexistantException;
import exception.uc4.UserExistantException;
import exception.uc4.UserInexistantException;

@Singleton
@LocalBean
public class FacDao {
	
	@EJB
	private DaoGestion daoGestion;
	
	public Mot add (Mot mot) throws UserExistantException {
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

	public void delete(Mot mot) throws UserInexistantException{
		try {
			daoGestion.delete(mot);
		}catch(InexistantException ie) {
			Throwable thro = ie.getCause();
				while ((thro!=null) && !(thro instanceof InexistantException)) {
					thro = thro.getCause();
				}
				if (thro instanceof InexistantException) throw new UserInexistantException();
		}
	}
	
	public Mot avoirMot(int idMot) throws UserInexistantException {
		Mot mot = null;
		try {
			mot = daoGestion.avoirMot(idMot);
		}catch(InexistantException ie) {
			Throwable thro = ie.getCause();
				while ((thro!=null) && !(thro instanceof InexistantException)) {
					thro = thro.getCause();
				}
				if (thro instanceof InexistantException) throw new UserInexistantException();
		}
		
		return mot;
	}
	
	public Mots listAllMot () {
		
		Mots listeMot = new Mots();
		
		listeMot = daoGestion.listAllMot();
		System.out.println("listAllMot_facDao" + listeMot);
		return listeMot;
	}
}
