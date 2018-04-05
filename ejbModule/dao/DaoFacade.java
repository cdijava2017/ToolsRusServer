package dao;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dao.gestionAcces.DaoAcces;
import entity.gestionAcces.Profil;
import entity.gestionAcces.Role;
import entity.gestionAcces.User;

@Singleton
@LocalBean
public class DaoFacade {

	@EJB
	private DaoAcces daoAcces;

	// ==Ousseynou_Gestion_acces-------------
	/**
	 * Mathode Dao_User
	 * 
	 * @param user
	 * @return
	 */
	public User add(User user) {
		return daoAcces.insert(user);
	}

	public User findbyId(int id) {
		return daoAcces.findUserId(id);
	}

	public User update(User user) {
		return daoAcces.majUser(user);
	}

	public void delate(User user) {
		daoAcces.supprimer(user);
	}

	public void delateIdUser(int id) {
		daoAcces.delIdUser(id);

	}

	public Profil addProfil(Profil profil) {
		return daoAcces.insertprofil(profil);
	}

	public void removeNativeUser() {
		daoAcces.removeNativeUser();

	}

	/**
	 * Mathode Dao_Profil
	 */
	public void removeNativeProfil() {
		daoAcces.removeNativeProfil();

	}

	public Profil findprofilbyId(int id) {
		return daoAcces.findProfilId(id);
	}

	/**
	 * Mathode Dao_Role
	 * 
	 * @param role
	 * @return
	 */
	public Role addRole(Role role) {
		return daoAcces.insertRole(role);

	}

	public void removeNativeRole() {
		daoAcces.removeNativeRole();

	}

	public Role findRoleById(int id) {
		return daoAcces.findRoleId(id);
	}

	// ====Fin_des_gestion_acces_======

}
