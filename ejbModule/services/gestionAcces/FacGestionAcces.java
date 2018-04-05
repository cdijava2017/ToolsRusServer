package services.gestionAcces;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import entity.gestionAcces.Profil;
import entity.gestionAcces.Role;
import entity.gestionAcces.User;

/**
 * Facade de la parie Gestion des acces
 * 
 * @author zinks
 *
 */
@Singleton
@LocalBean
public class FacGestionAcces {

	@EJB
	private GererAcces gererAcces;

	/***
	 * Facade gestion user
	 * */ 

	public User ajouter(User user) {
		return gererAcces.ajouter(user);

	}

	public User getUserbyId(int id) {
		return gererAcces.recuperUserbyId(id);
	}

	public User updateUser(User user) {
		return gererAcces.miseajour(user);
	}

	public void remove(User user) {
		gererAcces.remove(user);

	}

	public void removeid(int id) {
		gererAcces.removeUserid(id);

	}

	public Profil ajouterProfile(Profil profil) {
		return gererAcces.ajoutProfil(profil);
	}

	public void removeNativeUser() {
		gererAcces.removeNativeUser();

	}

	public void removeNativeProfil() {
		gererAcces.removeNativeProfil();

	}

	public Profil getProfilbyId(int id) {
		return gererAcces.recuperProfilById(id);
	}

	public Role ajouterProfile(Role role) {
		return gererAcces.ajouterRole(role);
	}
/**
 * Facade gestion Role
 */
	public void removeNativeRole() {
		gererAcces.removeNativeRole();

	}

	public Role getRolebyId(int id) {
		return gererAcces.recupeRoleById(id);
	}

}
