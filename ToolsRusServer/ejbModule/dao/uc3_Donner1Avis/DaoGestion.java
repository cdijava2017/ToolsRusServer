package dao.uc3_Donner1Avis;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireVideException;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.CompteurVideException;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.TitreVideException;

@Singleton
@LocalBean
public class DaoGestion {

	@PersistenceContext(unitName="DMhibernate")
	private EntityManager em;

	
	/*****************************************************************************
	 * Cette partie concerne les Documents et aura toutes les méthodes relatives *
	 * @throws DocumentVideException 											 *
	 *****************************************************************************/
	
	public Commentaire ajouter(Commentaire commentaire) throws CommentaireVideException {
		try {
			if (commentaire != null) {
				em.persist(commentaire);
				em.flush();
			}
			else { 
				throw new CommentaireVideException();
			}
		}
		catch (PersistenceException e) {	
			System.out.println(e);
		}
		return commentaire;
	}
		
	public void supAllCommentaires() {
		try {
			em.createQuery("delete from Commentaire").executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**************************************************************************
	 * Cette partie concerne les Titres et aura toutes les méthodes relatives *
	 * @throws DocumentVideException 										  *
	 **************************************************************************/
	
	public Titre ajouter(Titre titre) throws TitreVideException {
		try {
			if (titre != null) {
				em.persist(titre);
				em.flush();
			}
			else { 
				throw new TitreVideException();
			}
		}
		catch (PersistenceException e) {	
			System.out.println(e);
		}
		return titre;
	}

	public void supAllTitres() {
		try {
			em.createQuery("delete from Titre").executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	/*****************************************************************************
	 * Cette partie concerne les Compteurs et aura toutes les méthodes relatives *
	 * @throws CompteurVideException 											 *
	 *****************************************************************************/
	
	public Compteur ajouter(Compteur compteur) throws CompteurVideException {
		try {
			System.out.println("addCompteur DaoGestion");
			if (compteur != null) {
				em.persist(compteur);
				em.flush();
			}
			else { 
				throw new CompteurVideException();
			}
		}
		catch (PersistenceException e) {	
			System.out.println(e);
		}
		return compteur;
	}
	

	public void supAllCompteurs() {
		try {
			em.createQuery("delete from Compteur").executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
//	public Document update (Document document) {
//
//		// si document est null : return
//		if (document != null) {
//			// traitement de la localisation
//			localisation = document.getLocalisation();
//			if (localisation != null)
//				try {
//					// si la localisation existe en base, on la recupere (on travaille sur lieu et emplacement)					
//					localisation = getLocalisation(localisation.getLieu(), localisation.getEmp());
//				} catch (InexistantException e) {
//					// si la Localisation n'existe pas en base, il faut la créer
//					localisation = add(localisation);
//				} 
//		} 
//		// on verifie que la localisation n'est pas deja affectee a un autre document que celui traite
//		localisationTrouvee = isAffecteLocalisation(document);
//		if (!localisationTrouvee) {			
//			document.setLocalisation(localisation);
//			System.out.println("*** DaoGestion - update(document) - document : " + document);
//			try {
//				em.merge(document);
//				em.flush();
//			}
//			catch (PersistenceException e) {				
//				Throwable t = e.getCause();
//				while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
//					t = t.getCause();
//				}
//				if (t instanceof SQLIntegrityConstraintViolationException) throw new DoublonException();
//			}
//		}
//		// la localisation est deja affectee
//		else {
//			throw new LocalisationAffecteeException();
//		}
//		return document;	
//	}
//
//
//	public void remove(Document document) throws InexistantException  {
//		if (document != null) {
//			removeDocument(document.getCote());
//		}
//	}
//
//	public void removeDocument(String cote) throws InexistantException  {
//		Document documentx = null;
//		System.out.println("******  DaoGestion - removeDocument(cote) " + cote);
//		try {
//			documentx = getDocument(cote);
//		} catch (InexistantException e) {
//			throw e;
//		}
//		try {
//			em.remove(documentx);
//			em.flush();
//		}
//		catch (PersistenceException e) {				
//			// recherche de la cause
//			Throwable t = e.getCause();
//			while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
//				t = t.getCause();
//			}
//			if (t instanceof SQLIntegrityConstraintViolationException) {
//				
//			}
//		}
//	}
//
//	public void removeDocumentNative() {
//		try {
//			em.createNativeQuery("delete from " + Param.TABLE_DOCUMENT).executeUpdate();
//			em.flush();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void removeDocument() {
//		try {
//			em.createQuery("delete from Document").executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	public Document getDocument(String cote) throws InexistantException {
//
//		//		Pour éviter les pb de chargement du lazy loading, 
//		//		on force le chargement de la localisation par une requete HQL
//		//		Document document = em.find(Document.class, cote);
//
//		Document document = null;
//		String SQL_QUERY 	="select d, l from Document d left outer join fetch d.localisation l where d.cote=?";
//
//		try { 
//			document 	= (Document) em.createQuery(SQL_QUERY).setParameter(1,cote).getSingleResult();
//		} catch (PersistenceException e) {	
//			if (e.getClass().equals(NoResultException.class)) {
//				throw new InexistantException();
//			}
//		}
//		return document;
//	}
//
//
//
//
//
//
//
//	/* ==========================================  
//	 * 			GESTION LOCALISATION
//	 * ========================================== */
//
//	/**
//	 * ajout de localisation
//	 * si elle existe deja on retourne l'objet du contexte 
//	 * @param localisation
//	 * @return
//	 * @throws DoublonException
//	 * @throws InexistantException 
//	 * @throws DiversException 
//	 */
//	public Localisation add(Localisation localisation) throws DoublonException {
//
//		System.out.println("*** DaoGestion - DEBUT - getLocalisation(localisation) : localisation : " + localisation);
//		Localisation loc = null;
//
//		try {
//			loc = getLocalisation(localisation);
//			localisation = loc; // on recupere l'objet du contexte
//		} catch (InexistantException e) {
//			System.out.println("*** DaoGestion - add(localisation) - loc InexistantException : " + loc);
//		}		
//		// si localisation inexistante en base
//		if (loc == null ) {
//			try { 
//				em.persist(localisation);
//				em.flush(); 
//			} catch (PersistenceException e) {	
//				Throwable t = e.getCause();
//				while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
//					t = t.getCause();
//
//				}
//				// si c'est une ConstraintViolationException
//				if (t instanceof SQLIntegrityConstraintViolationException) {
//					throw new DoublonException();
//				}
//			}
//		}
//		return localisation;
//	}
//
//	public Localisation update (Localisation localisation) throws DoublonException   {
//		try {
//			localisation = em.merge(localisation);
//			em.flush();
//
//		} catch (PersistenceException e) {	
//			Throwable t = e.getCause();
//			while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
//				t = t.getCause();
//
//			}
//			// si c'est une ConstraintViolationException
//			if (t instanceof SQLIntegrityConstraintViolationException) {
//				throw new DoublonException();
//			}
//		}
//		return localisation;
//	}
//
//	public void remove(Localisation localisation) throws InexistantException, LocalisationAffecteeException  {
//		if (localisation != null) {
//			Localisation localisationx = getLocalisation(localisation.getIdLocalisation());
//			if (localisationx != null) {
//				if (isAffecteLocalisation(localisationx)) throw new LocalisationAffecteeException();
//				else em.remove(localisationx);
//			}
//			else throw new InexistantException();
//		}
//	}
//
//
//	public void removeLocalisation(int id) throws InexistantException, LocalisationAffecteeException {
//		Localisation localisationx = getLocalisation(id);
//		remove(localisationx);
//	}
//
//	public void removeLocalisationNative() {
//		em.createNativeQuery("delete from " + Param.TABLE_LOCALISATION).executeUpdate();
//		em.flush();
//	}
//
//	public void removeLocalisation() {
//		em.createQuery("delete from Localisation").executeUpdate();
//	}
//
//	/**
//	 * Retourne localisation par id
//	 * si pas trouve : new InexistantException()
//	 * @throws InexistantException 
//	 */
//	public Localisation getLocalisation(int id) throws InexistantException {
//		Localisation localisation = null;
//		try { 
//			localisation = em.find(Localisation.class, id);
//		} catch (PersistenceException e) {				
//			// recherche de la cause
//			Throwable t = e.getCause();
//			while ((t != null) && !(t instanceof NoResultException)) {
//				t = t.getCause();
//			}
//			if (t instanceof NoResultException) {
//				throw new InexistantException();
//			}
//		}
//		//		if (localisation == null) throw new InexistantException(String.format("Localisation id[%s] inconnue", id), 1);
//		return localisation;
//	}
//
//	/**
//	 * Retourne localisation par lieu, emp
//	 * si pas trouve : new InexistantException() - localisation = null
//	 * @throws InexistantException 
//	 */
//	public Localisation getLocalisation(String lieu, String emp) throws InexistantException {
//		System.out.println("*** DaoGestion - getLocalisation(lieu,emp) ");
//		Localisation localisation = null;
//		String SQL_QUERY 	="select l from Localisation l where l.lieu = ? and l.emp = ? ";
//		Query query = em.createQuery(SQL_QUERY);
//		query.setParameter(1,lieu);
//		query.setParameter(2,emp);
//
//		try { 
//			localisation = (Localisation) query.getSingleResult();
//		} catch (PersistenceException e) {	
//			if (e.getClass().equals(NoResultException.class)) {
//				System.out.println("*** DaoGestion - getLocalisation(lieu,emp) - throw : " + e.getClass());
//				throw new InexistantException();
//			}
//		} 
//		System.out.println("*** DaoGestion - getLocalisation(lieu,emp) - localisation :  " + localisation);
//
//		return localisation;
//	}
//
//
//	/**
//	 * Retourne localisation par lieu, emp de l'objet localisation
//	 * null si pas trouve
//	 * @throws InexistantException 
//	 */
//	public Localisation getLocalisation(Localisation localisation) throws InexistantException {
//		System.out.println("*** DaoGestion - DEBUT - getLocalisation(localisation) : localisation : " + localisation);
//		if (localisation != null) localisation = getLocalisation(localisation.getLieu(),localisation.getEmp());
//
//		return localisation;
//	}
//
//	/**
//	 * Retourne id de localisation
//	 * null si pas trouve
//	 * @throws InexistantException 
//	 */
//	public Integer getLocalisationId(String lieu, String emp) throws InexistantException {
//		Integer id = null;
//		Localisation localisation = getLocalisation(lieu,emp);
//		if (localisation != null) id = localisation.getIdLocalisation();
//		return id;
//	}
//
//	/**
//	 * Retourne id de localisation
//	 * null si pas trouve
//	 * @throws InexistantException 
//	 */
//	public Integer getLocalisationId(Localisation localisation) throws InexistantException {
//		Integer id = null;
//		Localisation localisationx = getLocalisation(localisation.getLieu(),localisation.getEmp());
//		if (localisationx != null) id = localisationx.getIdLocalisation();
//		return id;
//	}
//
//	/**
//	 *  Verifie si la localisation est affectee a un document
//	 */
//	public boolean isAffecteLocalisation(Localisation localisation) {
//
//		System.out.println("*** DaoGestion - isAffecteLocalisation(localisation) - localisation : " + localisation);
//		// on part du principe que la localisation n'est pas affectee a un document
//		boolean trouve = false;
//
//		// on recherche la localisation en BDD
//		if (localisation != null) {
//			Localisation loc;
//			try {
//				loc = getLocalisation(localisation.getLieu(), localisation.getEmp());
//				//	System.out.println("*** DaoGestion - isAffecteLocalisation(localisation) - apres getLocalisation(lieu,emp) - loc : " + loc);
//
//				// si on trouve, on regarde si elle est associee a un document
//				Query query = em.createQuery("select d from Document d where d.localisation = ? ");
//				query.setParameter(1,loc);
//				query.getSingleResult();
//				trouve = true;
//
//			} catch (InexistantException e) {
//				// erreur en provenance de getLocalisation(lieu,emp) - on ne trouve pas la localisation - on ne fait rien
//			} catch (PersistenceException e) {				
//				// erreur en provenance du select document - on ne trouve pas le document on ne fait rien
//			} 
//		}
//		//		System.out.println("*** DaoGestion - isAffecteLocalisation(localisation) - fin - trouve : " + trouve);
//		return trouve;
//	}
//
//	/**
//	 *  Verifie que la localisation n'est pas affectee a un autre document que celui donne en parametre
//	 */
//	public boolean isAffecteLocalisation(Document document) {
//
//		System.out.println("*** DaoGestion - isAffecteLocalisation(document) - document : " + document);
//		// on part du principe que la localisation n'est pas affectee a un document
//		boolean trouve = false;
//
//		// on recherche la localisation en BDD
//		if (document != null) {
//			Localisation localisation = document.getLocalisation();
//			if (localisation != null) {
//				Localisation loc;
//				try {
//					loc = getLocalisation(localisation.getLieu(), localisation.getEmp());
//					if (loc != null ) {
//						// si on trouve, on regarde si elle est associee a un autre document que celui passe en parametre 
//						Query query = em.createQuery("select d from Document d where d.localisation = ? and d.cote <> ?");
//						query.setParameter(1,loc);
//						query.setParameter(2,document.getCote());
//						query.getSingleResult();
//						trouve = true;
//					}
//				} catch (InexistantException e) {
//					// erreur en provenance de getLocalisation(lieu,emp) - on ne trouve pas la localisation - on ne fait rien
//				} catch (PersistenceException e) {				
//					// erreur en provenance du select document - on ne trouve pas le document on ne fait rien
//				} 
//			}
//		}
//		//		System.out.println("*** DaoGestion - isAffecteLocalisation(document) - fin - trouve : " + trouve);
//		return trouve;
//	}

}
