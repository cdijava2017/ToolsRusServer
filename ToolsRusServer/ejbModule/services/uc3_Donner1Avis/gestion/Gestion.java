package services.uc3_Donner1Avis.gestion;

import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dao.uc3_Donner1Avis.DaoGestion;
import dao.uc3_Donner1Avis.DaoListe;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireVideException;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.CompteurVideException;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.TitreVideException;

@Singleton
@LocalBean
public class Gestion {

	@EJB private DaoGestion daoGestion;
	
	@EJB private DaoListe daoListe;

	/*****************************************************************************
	 * Cette partie concerne les Commentaires et aura toutes les méthodes relatives *
	 * @throws CommentaireVideException 											 *
	 *****************************************************************************/
	
	public Commentaire creerComm(Commentaire commentaire) throws CommentaireVideException {
		try {
			Objects.requireNonNull(commentaire);
			daoGestion.ajouter(commentaire);
		}
		catch(NullPointerException npe) {
			System.out.println("Attention : NullPointerException pour le commentaire!");
		}
		return commentaire;
	}

	public void supAllCommentaires() {
		daoGestion.supAllCommentaires();
	}
	
	public void modifCommentaire(Commentaire commentaire) {
		try {
			daoGestion.modifCommentaire(commentaire);
		} catch (Exception e) {
			System.out.println("Attention, Exception levée à la modification du commentaire : " + e.getMessage());
		}
	}
	
	/**************************************************************************
	 * Cette partie concerne les Titres et aura toutes les méthodes relatives *
	 * @throws TitreVideException 										  *
	 **************************************************************************/
	
	public Titre creerTitre(Titre titre) throws TitreVideException {
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
	
	public Compteur creerCompteur(Compteur compteur) throws CompteurVideException {
		try {
			System.out.println("addCompteur Gestion");
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
	
	public void incrementerCompteur(Compteur compteur) {
		try {
			daoGestion.incrementerCompteur(compteur);
		} catch (Exception e) {
			System.out.println("Attention, Exception levée pendant l'incrémentation du compteur : " + e.getMessage());
		}
	}
//	public void modifier(Localisation localisation) {
//		try {
//			daoGestion.update(localisation);
//		} catch (DaoException e) {
//			System.out.println("!!!!! DM Erreur : " + e.getCode() + ":" + e.getMessage());
//		}
//		
//	}
//
//	@Override
//	public void supAllCalcul() {
//		daoG.deleteAll();
//		
//	}
//
//	@Override
//	public void supByRef(int ref) {
//		try {
//			Calcul calcul =  daoC.getByRef(ref);
//			daoG.delete(calcul);
//		} catch (DaoException e) {
//			System.out.println("!!!!! DM Erreur : " + e.getCode() + ":" + e.getMessage());
//		}
//		
//	}
//
//	@Override
//	public void sup(Calcul calcul) {
//		try {
//			daoG.delete(calcul);
//		} catch (DaoException e) {
//			System.out.println("!!!!! DM Erreur : " + e.getCode() + ":" + e.getMessage());
//		}
//		
//	}


}
