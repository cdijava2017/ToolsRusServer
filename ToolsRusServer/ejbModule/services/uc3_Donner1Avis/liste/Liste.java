package services.uc3_Donner1Avis.liste;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dao.uc3_Donner1Avis.DaoException;
import dao.uc3_Donner1Avis.DaoListe;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.Commentaires;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.Titres;



@Singleton
@LocalBean
public class Liste {

	@EJB private DaoListe daoListe;


	/*******************************************************************************
	 * Cette partie concerne les Commentaires et aura toutes les méthodes relatives*
	 *******************************************************************************/
	
	public Commentaires getAllCommParId() {

		Commentaires commentaires = daoListe.getAllCommParId();
		return commentaires;
	}

	public Commentaire getCommParRef(int ref) {
		Commentaire commentaire = null;
		try {
			commentaire = daoListe.getCommParRef(ref);
		} catch (DaoException e) {
			System.out.println(e);
		}
		return commentaire;
	}


	/*************************************************************************
	 * Cette partie concerne les Titres et aura toutes les méthodes relatives*
	 *************************************************************************/
	
	public Titres getAllTitreParId() {

		Titres titres = daoListe.getAllTitreParId();
		return titres;
	}

	public Titre getTitreParRef(int ref) {
		Titre titre = null;
		try {
			titre = daoListe.getTitreParRef(ref);
		} catch (DaoException e) {
			System.out.println("!!!!! DM Erreur : " + e.getCode() + ":" + e.getMessage());
		}
		return titre;
	}


//	/***************************************************************************
//	 * Cette partie concerne les Auteurs et aura toutes les méthodes relatives
//	 ***************************************************************************/
//	
//	public Auteurs getAllAuteurParId() {
//		
//		Auteurs auteurs = daoListe.getAllAuteurParId();
//		return auteurs;
//	}
//	
//	public Auteur getAuteurParRef(int ref) {
//		Auteur auteur = null;
//		try {
//			auteur = daoListe.getAuteurParRef(ref);
//		} catch (DaoException e) {
//			System.out.println("!!!!! DM Erreur : " + e.getCode() + ":" + e.getMessage());
//		}
//		return auteur;
//	}
}
