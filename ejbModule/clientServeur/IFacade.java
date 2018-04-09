package clientServeur;

import java.util.List;

import entity.gestionAcces.Profil;
import entity.gestionAcces.Role;
import entity.gestionAcces.User;
import parametreGestionAcces.UserException;

public interface IFacade {

	// Ousseynou
	// Dao_Gestion
	/**
	 * implement User
	 * 
	 * @param user
	 * @throws UserException
	 */

	public User addNewUser(User user) throws UserException;

	public User updUser(User user) throws UserException;

	public void delUser(User user) throws UserException;

	public void delUserByid(int id);

	public User getUser(int id);

	public void removeNativeUser();

	/**
	 * implement profil
	 * 
	 * @param profil
	 */
	public Profil addNewProfile(Profil profil) throws UserException;

	public Profil updProfile(Profil profil) throws UserException;

	public void delProfile(Profil profil);

	public void delProfileByid(int id);

	public Profil getProfil(int id);

	public void removeNativeProfil();

	/**
	 * implement La classe mere abstraite Role pour
	 * Participant,Animateur,SuperAdministrateur
	 * 
	 * @param role
	 * @return
	 */
	public Role addRole(Role role);

	public Role updRole(Role role);

	public void delRole(Role role);

	public Role getRole(int id);

	public void delRoleByid(int id);

	public void removeNativeRole();

	/*
	 * Dao_Liste_Acces
	 */
	// PRofil List
	public List<Profil> getAllbyProfilById();

	public List<Profil> getAllbyProfilByNom();

	public List<Profil> getAllbyProfilByPrenom();

	// User List
	public List<User> getAllbyUserById();

	public List<User> getAllbyUserByPseudo();
	// =================== FIN ousseynou

	/**
	 * implement Image
	 * 
	 * @param
	 */

}
