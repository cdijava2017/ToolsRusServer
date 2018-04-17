package services.uc3_Donner1Avis.gestion;

import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.PersistenceException;

import dao.uc3_Donner1Avis.DaoException;
import dao.uc3_Donner1Avis.DaoGestion;
import dao.uc3_Donner1Avis.DaoListe;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireException;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.CompteurVideException;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.TitreVideException;

@Singleton
@LocalBean
public class Gestion {

	@EJB private DaoGestion daoGestion;

	@EJB private DaoListe daoListe;

	/********************************************************************************
	 * Cette partie concerne les Commentaires et aura toutes les méthodes relatives *
	 * @throws CommentaireException 											*
	 ********************************************************************************/

	public Commentaire creerComm(Commentaire commentaire) throws CommentaireException {
		try {
			Objects.requireNonNull(commentaire);
			commentaire = daoGestion.ajouter(commentaire);
		}
		catch(NullPointerException npe) {
			System.out.println("Attention : NullPointerException pour le commentaire!");
		} catch (DaoException e) {
			if (e.getCode() == 1) throw new CommentaireException("*** Attention le commentaire est vide ***");
			if (e.getCode() == 2) throw new CommentaireException("*** Attention, un commentaire existe déjà en base avec cet id ***");
		}
		return commentaire;
	}

	public void supAllCommentaires() {
		daoGestion.supAllCommentaires();
	}

	public void supCommParId(int idComm) throws CommentaireException {
		try {
			daoGestion.supCommParId(idComm);
		} catch (DaoException e) {
			if (e.getCode() == 3) throw new CommentaireException("*** Attention, aucun commentaire n'existe en base avec cet id ***");
		}
	}

	public void modifCommentaire(Commentaire commentaire) throws CommentaireException {
		try {
			daoGestion.modifCommentaire(commentaire);
		} catch (DaoException e) {
			if (e.getCode() == 3) throw new CommentaireException(e.getMessage());
		}
	}

	/**************************************************************************
	 * Cette partie concerne les Titres et aura toutes les méthodes relatives *
	 * @throws TitreVideException 										  	  *
	 **************************************************************************/

	public Titre creerTitre(Titre titre) throws DaoException {
		try {
			Objects.requireNonNull(titre);
			daoGestion.ajouter(titre);
		}
		catch(NullPointerException npe) {
			System.out.println("Attention : NullPointerException pour le titre!");
		}
		return titre;
	}

	public void supAllTitres() {
		daoGestion.supAllTitres();
	}

	public void modifTitre(Titre titre) {
		try {
			daoGestion.modifTitre(titre);
		} catch (Exception e) {
			System.out.println("Attention, Exception levée à la modification du titre : " + e.getMessage());
		}
	}

	/*****************************************************************************
	 * Cette partie concerne les Compteurs et aura toutes les méthodes relatives *
	 * @throws CompteurVideException 											 *
	 *****************************************************************************/

	public Compteur creerCompteur(Compteur compteur) throws DaoException {
		try {
			Objects.requireNonNull(compteur);
			daoGestion.ajouter(compteur);
		}
		catch(NullPointerException npe) {
			System.out.println("Attention : NullPointerException pour le compteur!");
		}
		return compteur;
	}

	public void supAllCompteurs() {
		daoGestion.supAllCompteurs();

	}

	public void modifCompteur(Compteur compteur) {
		try {
			daoGestion.modifCompteur(compteur);
		} catch (Exception e) {
			System.out.println("Attention, Exception levée à la modification du compteur : " + e.getMessage());
		}
	}

	public void incrementCompteur(int idCompteur) {
		daoGestion.incrementCompteur(idCompteur);
	}





}
