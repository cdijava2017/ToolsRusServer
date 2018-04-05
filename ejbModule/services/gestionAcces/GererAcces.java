package services.gestionAcces;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dao.DaoFacade;
import entity.gestionAcces.Profil;
import entity.gestionAcces.Role;
import entity.gestionAcces.User;

@Singleton
@LocalBean
public class GererAcces {
	/**
	 * Couche service pour la dao
	 */
	@EJB
	private DaoFacade daoFacade;

	/**
	 * Ajout d'un user dans la Dao
	 * 
	 * @param user
	 * @return
	 */
	public User ajouter(User user) {
		// controler les datas
		if (user != null) {
			// mettre en place les regles de gestion
			daoFacade.add(user);
		} else {
			System.out.println("erreur sur l'ajout user au niveau du ServiceGerer acces");
		}
		return user;
	}

	public User recuperUserbyId(int id) {
		User user = null;
		if (id != 0) {
			user = daoFacade.findbyId(id);
		}
		return user;
	}

	public User miseajour(User user) {
		if (user != null) {
			user = daoFacade.update(user);
		} else {
			System.out.println("erreur sur maj user au niveau du ServiceGerer acces");
		}
		return user;
	}

	public void remove(User user) {
		daoFacade.delate(user);

	}

	public void removeUserid(int id) {
		daoFacade.delateIdUser(id);

	}

	/**
	 * ajout Profil dans dao
	 * 
	 * @param profil
	 * @return
	 */
	public Profil ajoutProfil(Profil profil) {
		if (profil != null) {
			// mettre en place les regles de gestion
			daoFacade.addProfil(profil);
		} else {
			System.out.println("erreur sur l'ajout profil au niveau du ServiceGerer acces");
		}
		return profil;
	}

	public void removeNativeUser() {
		daoFacade.removeNativeUser();

	}

	public void removeNativeProfil() {
		daoFacade.removeNativeProfil();

	}

	public Profil recuperProfilById(int id) {
		Profil profil = null;
		if (id != 0) {
			profil = daoFacade.findprofilbyId(id);
		}
		return profil;
	}

	/***
	 * ajout role dans dao
	 * 
	 * @param role
	 * @return
	 */

	public Role ajouterRole(Role role) {
		if (role != null) {
			// mettre en place les regles de gestion
			daoFacade.addRole(role);
		} else {
			System.out.println("erreur sur l'ajout role au niveau du ServiceGerer acces");
		}
		return role;
	}

	public void removeNativeRole() {
		daoFacade.removeNativeRole();

	}

	public Role recupeRoleById(int id) {
		Role role = null;
		if (id != 0) {
			role = daoFacade.findRoleById(id);
		}
		return role;
	}

	public Role miseajourRole(Role role) {
		if (role != null) {
			role = daoFacade.updateRole(role);
		} else {
			System.out.println("erreur sur maj role au niveau du ServiceGerer acces");
		}
		return role;
	}

	public void removeRole(Role role) {
		daoFacade.delateRole(role);		
	}

	public void removeRoleId(int nom) {
		daoFacade.delateRoleId(nom);	
	}

}
