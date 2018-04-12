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
import entity.uc3_Donner1Avis.compteur.CptDislike;
import entity.uc3_Donner1Avis.compteur.CptLike;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.TitreVideException;

@Singleton
@LocalBean
public class DaoGestion {

	@PersistenceContext(unitName="DMhibernate")
	private EntityManager em;


	/*****************************************************************************
	 * Cette partie concerne les Commentaires et aura toutes les m�thodes relatives *
	 * @throws CommentaireVideException 											 *
	 *****************************************************************************/

	public Commentaire ajouter(Commentaire commentaire) throws CommentaireVideException {
		try {
			// On teste si le commentaire n'est pas null
			if (commentaire != null) {
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
				// Si la liste a plus de 2 compteur, on la vide et lui rajoute 1 compteur de chaque � 0
				} else if (commentaire.getListeCompteurs().size() > 2) {
					commentaire.setListeCompteurs(null);
					commentaire.addCompteur(new CptDislike(0));
					commentaire.addCompteur(new CptLike(0));
				}
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
			em.createQuery("delete from Commentaire").executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void supCommParId(Commentaire commentaire) {
		commentaire = recupCommentaire(commentaire.getIdComm());
		em.remove(commentaire);
	}
	
	public void modifCommentaire(Commentaire commentaire) {
		Commentaire commentaireBis = recupCommentaire(commentaire.getIdComm());
		if (commentaire != commentaireBis) em.merge(commentaire);
		em.flush();
	}
	
	public Commentaire recupCommentaire(int id) {
		Commentaire commentaire = em.find(Commentaire.class, id);
		return commentaire;
	}

	/**************************************************************************
	 * Cette partie concerne les Titres et aura toutes les m�thodes relatives *
	 * @throws TitreVideException 										  *
	 **************************************************************************/

	public Titre ajouter(Titre titre) throws TitreVideException {
		System.out.println("DaoGestion m�thode ajouter() Titre");
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
	
	/**
	 *  <p>La m�thode supAllTitres() est fonctionnelle mais ne sera jamais appel�e par le client Web.</p>
	 *  <p>Elle n'est cod�e qu'� des fins de tests car il ne sera pas possible de supprimer un titre depuis le client Web.</p>
	 */
	public void supAllTitres() {
		System.out.println("DaoGestion m�thode supAllTitres() ");
		try {
			em.createQuery("delete from Titre").executeUpdate();
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

	/*****************************************************************************
	 * Cette partie concerne les Compteurs et aura toutes les m�thodes relatives *
	 * @throws CompteurVideException 											 *
	 *****************************************************************************/

	public Compteur ajouter(Compteur compteur) throws CompteurVideException {
		try {
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

	/**
	 *  <p>La m�thode supAllCompteurs() est fonctionnelle mais ne sera jamais appel�e par le client Web.</p>
	 *  <p>Elle n'est cod�e qu'� des fins de tests car il ne sera pas possible de supprimer un compteur depuis le client Web.</p>
	 */
	public void supAllCompteurs() {
		System.out.println("DaoGestion m�thode supAllCompteurs() ");
		try {
			em.createQuery("delete from Compteur").executeUpdate();
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

	public void incrementCompteur(Compteur compteur) {
		compteur.compteurPlus1();
	}


}
