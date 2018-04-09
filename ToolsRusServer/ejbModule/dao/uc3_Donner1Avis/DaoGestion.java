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
	 * Cette partie concerne les Commentaires et aura toutes les m�thodes relatives *
	 * @throws CommentaireVideException 											 *
	 *****************************************************************************/

	public Commentaire ajouter(Commentaire commentaire) throws CommentaireVideException {
		System.out.println("DaoGestion m�thode ajouter() commentaire");
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
		System.out.println("** DaoGestion - ajouter(Commentaire commentaire) : " + commentaire);
		return commentaire.commToDto();
	}

	public void supAllCommentaires() {
		System.out.println("DaoGestion m�thode supAllCommentaires() commentaire");
		try {
			em.createQuery("delete from Commentaire").executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void supCommParId(Commentaire commentaire) {
		System.out.println("DaoGestion m�thode supCommParId() commentaire");
		//TODO � coder
	}
	
	public void modifCommentaire(Commentaire commentaire) {
		System.out.println("DaoGestion m�thode modifCommentaire() " + commentaire);
//		Commentaire commentaireBis = recupCommentaire(commentaire.getIdComm());
//		if (commentaire != commentaireBis) 
			em.merge(commentaire);
		em.flush();
	}
	
	public Commentaire recupCommentaire(int id) {
		System.out.println("DaoGestion m�thode recupCommentaire() commentaire");
		Commentaire commentaire = em.find(Commentaire.class, id);
		return commentaire.commToDto();
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

	public void supAllTitres() {
		System.out.println("DaoGestion m�thode supAllTitres() ");
		try {
			em.createQuery("delete from Titre").executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void supTitreParId(Titre titre) {
		System.out.println("DaoGestion m�thode supTitreParId() ");
		//TODO � coder
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
		System.out.println("DaoGestion m�thode ajouter() Compteur");
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
		System.out.println("DaoGestion m�thode supAllCompteurs() ");
		try {
			em.createQuery("delete from Compteur").executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void supCompteurParId(Compteur compteur) {
		System.out.println("DaoGestion m�thode supCompteurParId() ");
		//TODO � coder
	}
	
	public void modifCompteur(Compteur compteur) {
		System.out.println("DaoGestion m�thode modifCompteur() ");
		System.out.println("***** 1 " + compteur);
		Compteur compteurBis = recupCompteur(compteur.getIdCompteur());
		System.out.println("***** 2 " + compteur);
		System.out.println("***** 3 bis" + compteurBis);
		if (compteur != compteurBis) em.merge(compteur);
		em.flush();
	}
	
	public Compteur recupCompteur(int id) {
		System.out.println("DaoGestion m�thode recupCompteur()");
		Compteur compteur = em.find(Compteur.class, id);
		return compteur;
	}

	public void incrementerCompteur(Compteur compteur) {
		System.out.println("DaoGestion m�thode incrementerCompteur() Compteur");
		Compteur compteurBis = recupCompteur(compteur.getIdCompteur());
		compteur.compteurPlus1();
		em.merge(compteur);
		em.flush();	
		
	}
	


}
