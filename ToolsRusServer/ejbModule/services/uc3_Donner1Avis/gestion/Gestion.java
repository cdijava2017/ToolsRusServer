package services.uc3_Donner1Avis.gestion;

import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dao.uc3_Donner1Avis.DaoGestion;
import dao.uc3_Donner1Avis.DaoListe;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireVideException;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.TitreVideException;

@Singleton
@LocalBean
public class Gestion {

	@EJB private DaoGestion daoGestion;
	
	@EJB private DaoListe daoListe;

	/*****************************************************************************
	 * Cette partie concerne les Documents et aura toutes les méthodes relatives *
	 * @throws DocumentVideException 											 *
	 *****************************************************************************/
	
	public Commentaire creerComm(Commentaire commentaire) throws CommentaireVideException {
		try {
			Objects.requireNonNull(commentaire);
			daoGestion.ajouter(commentaire);
		}
		catch(NullPointerException npe) {
			System.out.println("Attention : NullPointerException!");
		}
		return commentaire;
	}
	

	public void supAllCommentaires() {
		daoGestion.supAllCommentaires();
		
	}
	
//	public void modifier(Document document) {
//		try {
//			daoGestion.update(document);
//		} catch (DaoException e) {
//			System.out.println("!!!!! DM Erreur : " + e.getCode() + ":" + e.getMessage());
//		}
//		
//	}
	
	/**************************************************************************
	 * Cette partie concerne les Titres et aura toutes les méthodes relatives *
	 * @throws DocumentVideException 										  *
	 **************************************************************************/
	
	public Titre creerTitre(Titre titre) throws TitreVideException {
		try {
			Objects.requireNonNull(titre);
			daoGestion.ajouter(titre);
		}
		catch(NullPointerException npe) {
			System.out.println("Attention : NullPointerException!");
		}
		return titre;
	}
	

	public void supAllTitres() {
		daoGestion.supAllTitres();
		
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
