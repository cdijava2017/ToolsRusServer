package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import clientServeur.IFacade;
import entity.gestionAcces.Profil;
import entity.gestionAcces.Role;
import entity.gestionAcces.User;
import parametreGestionAcces.UserException;
import services.gestionAcces.FacGestionAcces;

/**
 * facade principale du projet serveur
 * 
 * @author Stag
 *
 */
@Stateless
@Remote(IFacade.class)
public class Facade implements IFacade {

	@EJB
	private FacGestionAcces gestionAcces;

	// ==============Debut_Gestion_Acces====================
	/**
	 * user
	 * 
	 * @throws UserException
	 **/
	@Override
	public User addNewUser(User user) {
		return gestionAcces.ajouter(user);
	}

	@Override
	public User updUser(User user) {
		return gestionAcces.updateUser(user);
	}

	@Override
	public void delUser(User user) {
		gestionAcces.remove(user);

	}

	@Override
	public void delUserByid(int id) {
		gestionAcces.removeid(id);

	}

	@Override
	public User getUser(int id) {
		return gestionAcces.getUserbyId(id);
	}

	@Override
	public void removeNativeUser() {
		gestionAcces.removeNativeUser();

	}

	/**
	 * Role
	 */
	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return gestionAcces.ajouterRole(role);
	}

	public void removeNativeRole() {
		gestionAcces.removeNativeRole();

	}

	@Override
	public Role updRole(Role role) {
		// TODO Auto-generated method stub
		return gestionAcces.updateRole(role);
	}

	@Override
	public void delRole(Role role) {
		gestionAcces.removeRole(role);

	}

	@Override
	public void delRoleByid(int id) {
		gestionAcces.removeRoleId(id);

	}

	@Override
	public Role getRole(int id) {
		return gestionAcces.getRolebyId(id);
	}

	/**
	 * profil
	 */
	@Override
	public Profil addNewProfile(Profil profil) {
		return gestionAcces.ajouterProfile(profil);
	}

	public void removeNativeProfil() {
		gestionAcces.removeNativeProfil();
	}

	@Override
	public Profil updProfile(Profil profil) {
		return gestionAcces.updateProfil(profil);
	}

	@Override
	public void delProfile(Profil profil) {
		gestionAcces.removeProfil(profil);
	}

	@Override
	public Profil getProfil(int id) {
		return gestionAcces.getProfilbyId(id);
	}

	@Override
	public void delProfileByid(int id) {
		gestionAcces.removeProfilById(id);

	}

	// ==============Fin_Gestion_Acces====================
	/*
	 * Debut List acces
	 */
	@Override
	public List<Profil> getAllbyProfilById() {
		// TODO Auto-generated method stub
		return gestionAcces.getAllbyProfilById();
	}

	@Override
	public List<Profil> getAllbyProfilByNom() {
		return gestionAcces.getAllbyProfilByNom();
	}

	@Override
	public List<Profil> getAllbyProfilByPrenom() {
		return gestionAcces.getAllbyProfilByPrenom();
	}

	@Override
	public List<User> getAllbyUserById() {
		// TODO Auto-generated method stub
		return gestionAcces.getAllbyUserById();
	}

	@Override
	public List<User> getAllbyUserByPseudo() {
		// TODO Auto-generated method stub
		return gestionAcces.getAllbyUserByPseudo();
	}

}
