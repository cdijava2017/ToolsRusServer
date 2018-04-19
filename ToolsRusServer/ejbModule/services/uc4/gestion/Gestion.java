package services.uc4.gestion;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dao.uc4.FacDao;
import entity.uc4.Mot;
import entity.uc4.Mots;
import exception.uc4.ExistantException;
import exception.uc4.UserExistantException;
import exception.uc4.UserInexistantException;

@Singleton
@LocalBean
public class Gestion {
	
	@EJB private FacDao facDao;

	public Mot ajouter(Mot mot) throws UserExistantException {
		facDao.add(mot);
		System.out.println("Gestion_ajouter  "+ mot);
		return mot;
	}
	
	public Mot update(Mot mot) throws ExistantException {
		facDao.update(mot);
		return mot;
	}

	public void supprimer(Mot mot) throws UserInexistantException {
		facDao.delete(mot);
	}
	
	public Mot getMot(int idMot) throws UserInexistantException {
		Mot mot = null;
		mot = facDao.avoirMot(idMot);
		return mot;
	}
	
	public Mots listAllMot () {
		Mots listeMot = new Mots();
		listeMot = facDao.listAllMot();
		return listeMot;
	}
}
