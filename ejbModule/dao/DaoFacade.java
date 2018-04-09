package dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.gestionAcces.DaoAcces;
import entity.gestionAcces.Profil;
import entity.gestionAcces.Role;
import entity.gestionAcces.User;

@Stateless
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

	public void removeNativeUser() {
		daoAcces.removeNativeUser();

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

	public Role updateRole(Role role) {
		return daoAcces.majRole(role);
	}

	public void delateRole(Role role) {
		daoAcces.supprimerRole(role);

	}

	public void delateRoleId(int id) {
		daoAcces.supprimerRoleId(id);

	}

	/**
	 * Mathode Dao_Profil
	 */

	public Profil addProfil(Profil profil) {
		return daoAcces.insertprofil(profil);
	}

	public void removeNativeProfil() {
		daoAcces.removeNativeProfil();

	}

	public Profil findprofilbyId(int id) {
		return daoAcces.findProfilId(id);
	}

	public Profil updateProfil(Profil profil) {
		return daoAcces.majProfil(profil);
	}

	public void delateProfileId(int id) {
		daoAcces.supprimerProfileId(id);
	}
	// ====Fin_des_gestion_acces_======

	/*
	 * Liste_Prodil
	 */

	public List<Profil> getAllbyProfilById() {
		return daoAcces.getAllbyProfilById();
	}

	public List<Profil> getAllbyProfilByNom() {
		return daoAcces.getAllbyProfilByNom();
	}

	public List<Profil> getAllbyProfilByPreNom() {
		return daoAcces.getAllbyProfilByPreNom();
	}

	public List<User> getAllbyUserById() {
		return daoAcces.getAllbyUserById();
	}

	public List<User> getAllbyUserByPseudo() {
		return daoAcces.getAllbyUserByPseudo();
	}

	
}
