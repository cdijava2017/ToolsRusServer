package dao.uc3_Donner1Avis;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;

import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.CptDislike;
import entity.uc3_Donner1Avis.compteur.CptLike;
import entity.uc3_Donner1Avis.titre.Titre;

@Singleton
@LocalBean
public class DaoGestion {

	@PersistenceContext(unitName=UtilBdD.PERSISTANCE_UNITNAME2)
	private EntityManager em;


	/********************************************************************************
	 * Cette partie concerne les Commentaires et aura toutes les m�thodes relatives *
	 * @throws DaoException 											 			*
	 ********************************************************************************/

	public Commentaire ajouter(Commentaire commentaire) throws DaoException {
		try {
			// On teste si le commentaire n'est pas null
			if (commentaire.getIdComm() != 0 && commentaire.getTexteComm() != null) {
				// S'il n'est pas null, alors on verifie les compteurs
				// Si la liste des compteurs est vide (null), alors on cr�� des compteurs � 0
				if (commentaire.getListeCompteurs().isEmpty()) {
					commentaire.addCompteur(new CptDislike(0));
					commentaire.addCompteur(new CptLike(0));
					// Si la liste n'a qu'un compteur, on lui rajoute l'autre
				} else if (commentaire.getListeCompteurs().size() == 1) {
					for (Compteur cpt : commentaire.getListeCompteurs()) {
						if (cpt instanceof CptLike) 	commentaire.addCompteur(new CptDislike(0));
						if (cpt instanceof CptDislike) 	commentaire.addCompteur(new CptLike(0));
					}
					// Si la liste a plus de 2 compteurs, on la vide et lui rajoute 1 compteur de chaque � 0
				} else if (commentaire.getListeCompteurs().size() > 2) {
					commentaire.setListeCompteurs(null);
					commentaire.addCompteur(new CptDislike(0));
					commentaire.addCompteur(new CptLike(0));
				}
				em.persist(commentaire);
				em.flush();
			}
			else { 
				throw new DaoException(UtilBdD.ERREUR_1, 1);
			}
		} catch (ConstraintViolationException e) {	
			System.out.println("*** Nacer commentaire : " + e.getMessage());
			throw new DaoException(UtilBdD.ERREUR_2, 2);
		} catch (PersistenceException e) {	
			System.out.println("*** Nacer commentaire : " + e.getMessage());
			throw new DaoException(UtilBdD.ERREUR_2, 2);
		} 
		System.out.println("** DaoGestion - ajouter(Commentaire commentaire) : " + commentaire);
		return commentaire.commToDto();
	}

	/**
	 *  <p>La m�thode supAllCommentaires() est fonctionnelle mais ne sera jamais appel�e par le client Web.</p>
	 *  <p>Elle n'est cod�e qu'� des fins de tests car il ne sera pas possible de supprimer tous les commentaires depuis le client Web.</p>
	 *  <p>En effet, je pars du principe qu'on ne peut supprimer qu'un commentaire � la fois.</p>
	 */
	public void supAllCommentaires() {
		System.out.println("DaoGestion m�thode supAllCommentaires() commentaire");
		try {
			em.createQuery(UtilBdD.DEL_COMMENTAIRE).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void supCommParId(int idComm) throws DaoException {
		Commentaire commentaire = recupCommentaire(idComm);
		em.remove(commentaire);
	}

	public void modifCommentaire(Commentaire commentaire) throws DaoException {
		Commentaire commentaireBis = recupCommentaire(commentaire.getIdComm());
		if (commentaire.getTexteComm().isEmpty()) 			
			commentaire.setTexteComm(commentaireBis.getTexteComm());
		if (commentaire.getTitre().getTxtTitre().isEmpty()) 
			commentaire.setTitre(commentaireBis.getTitre());
		if (commentaire.getListeCompteurs().isEmpty()) 		
			commentaire.setListeCompteurs(commentaireBis.getListeCompteurs());
		if (commentaire != commentaireBis) 
			em.merge(commentaire);
		em.flush();
	}

	public Commentaire recupCommentaire(int id) throws DaoException {
		Commentaire commentaire;
		try {
			commentaire = em.find(Commentaire.class, id);
		} catch (IllegalArgumentException e) {
			throw new DaoException(UtilBdD.ERREUR_3, 3);
		}
		return commentaire;
	}

	/**********************************************************************************
	 * <p>Cette partie concerne les Titres et aura toutes les m�thodes relatives</p>  *
	 * <p>La partie des titres n'est pas utilis�e dans le client web car ils cr��s 	  *
	 * � l'ajout d'un commentaire en base et sont positionn� en cascade. Ensuite, 	  *
	 * ils peuvent �tre modifi�s mais ne sont jamais g�r�s individuellement. </p>	  *
	 * <p>Tout est fonctionnel mais ces m�thodes ne seront jamais appel�es par le 	  *
	 * client Web. Elles ne sont cod�es qu'� des fins de tests car il ne sera pas 	  *
	 * possible de supprimer un titre ou le modifier sp�cifiquement depuis le client  *
	 * Web sans passer par la modification du commentaire.</p>	  					  *
	 * @throws DaoException 										  				  *
	 **********************************************************************************/

	public Titre ajouter(Titre titre) throws DaoException {
		System.out.println("DaoGestion m�thode ajouter() Titre");
		try {
			if (titre != null) {
				em.persist(titre);
				em.flush();
			}
			else { 
				throw new DaoException("*** Attention, erreur � la persistence du titre ***");
			}
		}
		catch (PersistenceException e) {	
			System.out.println("*** Nacer titre : " + e.getMessage());
			throw new DaoException(UtilBdD.ERREUR_2_2);
		}
		return titre;
	}

	/**
	 *  <p>La m�thode supAllTitres() est fonctionnelle mais ne sera jamais appel�e par le client Web.</p>
	 *  <p>Elle n'est cod�e qu'� des fins de tests car il ne sera pas possible de supprimer un titre depuis le client Web.</p>
	 */
	public void supAllTitres() {
		System.out.println("DaoGestion m�thode supAllTitres() ");
		try {
			em.createQuery(UtilBdD.DEL_TITRE).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modifTitre(Titre titre) {
		System.out.println("DaoGestion m�thode modifTitre() ");
		Titre titreBis = recupTitre(titre.getIdTitre());
		if (titre != titreBis) em.merge(titre);
		em.flush();
	}

	public Titre recupTitre(int id) {
		System.out.println("DaoGestion m�thode recupTitre() ");
		Titre titre = em.find(Titre.class, id);
		return titre;
	}

	/*************************************************************************************
	 * <p>Cette partie concerne les Compteurs et aura toutes les m�thodes relatives.</p> *
	 * <p>La partie des compteurs n'est pas utilis�e dans le client web � l'exception    *
	 *  des m�thodes incrementCompteur() et recupCompteur() car ils cr��s � l'ajout 	 *
	 *  d'un commentaire en base et sont positionn� en cascade. </p>	 				 *
	 * @throws DaoException 											 		 	 	 *
	 *************************************************************************************/

	public Compteur ajouter(Compteur compteur) throws DaoException {
		try {
			if (compteur != null) {
				em.persist(compteur);
				em.flush();
			}
			else { 
				throw new DaoException("*** Attention, erreur � la persistence du compteur ***");
			}
		}
		catch (PersistenceException e) {	
			System.out.println("*** Nacer : " + e.getMessage());
			throw new DaoException(UtilBdD.ERREUR_3_2);
		}
		return compteur;
	}

	/**
	 *  <p>La m�thode supAllCompteurs() est fonctionnelle mais ne sera jamais appel�e par le client Web.</p>
	 *  <p>Elle n'est cod�e qu'� des fins de tests car il ne sera pas possible de supprimer un compteur depuis le client Web.</p>
	 */
	public void supAllCompteurs() {
		System.out.println("DaoGestion m�thode supAllCompteurs() ");
		try {
			em.createQuery(UtilBdD.DEL_COMPTEUR).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *  <p>La m�thode modifCompteur() est fonctionnelle mais ne sera jamais appel�e par le client Web.</p>
	 *  <p>Elle n'est cod�e qu'� des fins de tests car il ne sera pas possible de modifier un compteur depuis le client Web.</p>
	 *  <p>En effet, je pars du principe qu'on ne peut qu'incr�menter un compteur et non pas le personnaliser.</p>
	 */
	public void modifCompteur(Compteur compteur) {
		Compteur compteurBis = recupCompteur(compteur.getIdCompteur());
		if (compteur != compteurBis) em.merge(compteur);
		em.flush();
	}

	public Compteur recupCompteur(int id) {
		Compteur compteur = em.find(Compteur.class, id);
		return compteur;
	}

	public void incrementCompteur(int idCompteur) {
		System.out.println(idCompteur);
		Compteur compteur = recupCompteur(idCompteur);
		System.out.println("*** DaoGestion, r�cup�ration compteur avant increment : " + compteur);
		compteur.compteurPlus1();
		modifCompteur(compteur);
	}


}
