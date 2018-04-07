package clientServeur;

import entity.gestionAcces.Profil;
import entity.gestionAcces.Role;
import entity.gestionAcces.User;
import parametreGestionAcces.UserException;

public interface IFacade {

	// Ousseynou

	/**
	 * implement User
	 * 
	 * @param user
	 * @throws UserException
	 */

	public User addNewUser(User user);

	public User updUser(User user);

	public void delUser(User user);

	public void delUserByid(int nom);

	public User getUser(int id);

	public void removeNativeUser();

	/**
	 * implement profil
	 * 
	 * @param profil
	 */
	public Profil addNewProfile(Profil profil);

	public Profil updProfile(Profil profil);

	public void delProfile(Profil profil);

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

	public void delRoleByid(int nom);

	public void removeNativeRole();

	// =================== FIN ousseynou

	/**
	 * implement Image
	 * 
	 * @param
	 */

}
