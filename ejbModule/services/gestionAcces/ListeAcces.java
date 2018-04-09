package services.gestionAcces;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dao.DaoFacade;
import entity.gestionAcces.Profil;
import entity.gestionAcces.User;

@Singleton
@LocalBean
public class ListeAcces {
	/**
	 * Couche service pour la dao
	 */
	@EJB
	private DaoFacade daoFacade;

	public List<Profil> getAllbyProfilById() {
		return daoFacade.getAllbyProfilById();
	}

	public List<Profil> getAllbyProfilByNom() {
		return daoFacade.getAllbyProfilByNom();
	}

	public List<Profil> getAllbyProfilByPreNom() {
		return daoFacade.getAllbyProfilByPreNom();
	}

	public List<User> getAllbyUserById() {
		return daoFacade.getAllbyUserById();
	}

	public List<User> getAllbyUserByPseudo() {
		return daoFacade.getAllbyUserByPseudo();
	}

}
