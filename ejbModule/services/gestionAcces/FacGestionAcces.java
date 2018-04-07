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
	 */

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

	public void removeNativeUser() {
		gererAcces.removeNativeUser();

	}

	/**
	 * Facade gestion Role
	 */
	public Role ajouterRole(Role role) {
		return gererAcces.ajouterRole(role);
	}

	public void removeNativeRole() {
		gererAcces.removeNativeRole();

	}

	public Role getRolebyId(int id) {
		return gererAcces.recupeRoleById(id);
	}

	public Role updateRole(Role role) {
		return gererAcces.miseajourRole(role);
	}

	public void removeRole(Role role) {
		gererAcces.removeRole(role);
	}

	public void removeRoleId(int id) {
		gererAcces.removeRoleId(id);
	}

	/**
	 * Profil User
	 * 
	 * @param profil
	 */

	public Profil ajouterProfile(Profil profil) {
		return gererAcces.ajoutProfil(profil);
	}

	public void removeNativeProfil() {
		gererAcces.removeNativeProfil();

	}

	public Profil getProfilbyId(int id) {
		return gererAcces.recuperProfilById(id);
	}

	public Profil updateProfil(Profil profil) {
		return gererAcces.miseAJourProfil(profil);
	}

	public void removeProfilById(int id) {
		gererAcces.removeProfileId(id);
	}

}
