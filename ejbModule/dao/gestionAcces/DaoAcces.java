package dao.gestionAcces;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.gestionAcces.Profil;
import entity.gestionAcces.Role;
import entity.gestionAcces.User;
import parametreGestionAcces.Parametres;

@Singleton
@LocalBean
public class DaoAcces {

	@PersistenceContext(unitName = Parametres.CONTEXT_PERSISTANCE)
	EntityManager em;

	/**
	 * Dao Gestion User
	 * 
	 * @param user
	 */
	public User insert(User user) {
		// control
		if (user != null) {
			em.persist(user);
		} else {
			System.out.println("erreur sur l'ajout User au niveau du DaoAcces ");
		}
		return user;
	}

	public User findUserId(int pseudo) {
		User user = null;
		if (pseudo != 0) {
			user = em.find(User.class, pseudo);
			System.out.println("trouver User au niveau du DaoAcces ");
		}
		return user;
	}

	public User majUser(User user) {
		if (user != null) {
			/**
			 * Rg Si l'id n'est pas renseigne ou mis a defaut user est null sinon si user
			 * existe ,modificationn effectif
			 */
			if (user.getId() == 0)
				user = null;
			else
				user = em.merge(user);
			System.out.println("update User au niveau du DaoAcces ");
		}
		return user;
	}

	public void supprimer(User user) {
		if (user != null) {
			/**
			 * Rg: on creer un user qu'on va cherche par rapport au type de l'entite de sa
			 * class et de son id en suite on le dequille pius on synchronize
			 */
			User usertrouver = em.find(User.class, user.getId());
			em.remove(usertrouver);
			em.flush();
			System.out.println("delate User au niveau du DaoAcces ");

		}

	}

	public void delIdUser(int id) {
		em.remove(em.getReference(User.class, id));
		System.out.println("delate User par son id au niveau du DaoAcces ");
	}

	/**
	 * Find () délivre l'entité à partir du cache du contexte de persistance ou s'il
	 * n'y est pas, il sera chargé à partir de la base de données. GetReference ()
	 * ne charge pas l'entité immédiatement. Un proxy (un certain objet, un
	 * soi-disant "adjoint" avec des méthodes enrichies pour charger l'entité
	 * réelle) est renvoyé. C'est donc une réalisation avec l'aide de LazyLoading.
	 * Seulement si les attributs du proxy ou d'autres méthodes de persistance sont
	 * nécessaires / appelé le proxy interagit et charge l'entité réelle à partir de
	 * la base de données.
	 * 
	 * Quand doit-on utiliser quelle méthode? L'utilisation de find () doit avoir la
	 * priorité sur les méthodes de requête, car find () peut renvoyer des entités
	 * déjà chargées à partir du cache du contexte de persistance. Si vous savez
	 * qu'une entité est nécessaire plus tard, l'utilisation de getReference () est
	 * un bon choix
	 * 
	 */

	public void removeNativeUser() {
		try {
			em.createNativeQuery("delete from " + Parametres.TBL_USER).executeUpdate();
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ------------------end_Dao_User--------
	/**
	 * Dao Gestion Role
	 * 
	 * @param role
	 */
	public Role insertRole(Role role) {
		if (role != null) {
			// mettre en place les regles de gestion
			em.persist(role);
		} else {
			System.out.println("erreur sur l'ajout profil au niveau du ServiceGerer acces");
		}
		return role;
	}

	public void removeNativeRole() {
		try {
			em.createNativeQuery("delete from " + Parametres.TBL_ROLE).executeUpdate();
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Role findRoleId(int id) {
		Role role = null;
		if (id != 0) {
			role = em.find(Role.class, id);
			System.out.println("trouver role au niveau du DaoAcces ");
		}
		return role;
	}

	public Role majRole(Role role) {
		if (role != null) {
			if (role.getId() == 0)
				role = null;
			else
				role = em.merge(role);
			System.out.println("update Role au niveau du DaoAcces ");
		}
		return role;
	}

	public void supprimerRoleId(int id) {
		em.remove(em.getReference(Role.class, id));
		System.out.println("delate Role par son id au niveau du DaoAcces ");

	}

	public void supprimerRole(Role role) {
		if (role != null) {
			Role roles = em.find(Role.class, role.getId());
			em.remove(roles);
			em.flush();
			System.out.println("delate Role au niveau du DaoAcces ");

		}

	}

	// ----------End_Dao_Role-----
	/***
	 * Dao Gestion Profil
	 * 
	 * @param profil
	 */

	public Profil insertprofil(Profil profil) {
		if (profil != null) {
			// mettre en place les regles de gestion
			em.persist(profil);
		} else {
			System.out.println("erreur sur l'ajout profil au niveau du ServiceGerer acces");
		}
		return profil;
	}

	public void removeNativeProfil() {
		try {
			em.createNativeQuery("delete from " + Parametres.TBL_PROFIL).executeUpdate();
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Profil findProfilId(int id) {
		Profil profil = null;
		if (id != 0) {
			profil = em.find(Profil.class, id);
			System.out.println("trouver Profil au niveau du DaoAcces  ");
		}
		return profil;
	}

	public Profil majProfil(Profil profil) {
		if (profil != null) {
			if (profil.getId() == 0)
				profil = null;
			else
				profil = em.merge(profil);
			System.out.println("update profil au niveau du DaoAcces ");
		}
		return profil;
	}

	public void supprimerProfileId(int id) {
		em.remove(em.getReference(Role.class, id));
		System.out.println("delate Profil par son id au niveau du DaoAcces ");

	}
	// ----------End_Dao_Profile-----
	/**
	 * Fin_de_la_DaO_GESTION_ACCES
	 */

	@SuppressWarnings("unchecked")
	public List<Profil> getAllbyProfilById() {
		
		Query query = em.createQuery("select p from Profil p order by p.id asc");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Profil> getAllbyProfilByNom() {
		Query query = em.createQuery("select p from Profil p order by p.nom asc");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Profil> getAllbyProfilByPreNom() {
		Query query = em.createQuery("select p from Profil p order by p.prenom asc");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllbyUserById() {
		Query query = em.createQuery("select u from User u order by u.id asc");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllbyUserByPseudo() {
		Query query = em.createQuery("select u from User u order by u.pseudo asc");
		return query.getResultList();
	}
}
