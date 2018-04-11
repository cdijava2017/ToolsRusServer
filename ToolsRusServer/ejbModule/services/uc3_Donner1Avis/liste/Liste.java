package services.uc3_Donner1Avis.liste;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dao.uc3_Donner1Avis.DaoException;
import dao.uc3_Donner1Avis.DaoListe;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.Commentaires;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.Compteurs;
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
		Commentaires recup = daoListe.getAllCommParId();
		Commentaires commentaires = null;
		for (Commentaire comm : recup) {
			comm = comm.commToDto();
			commentaires.add(comm);
		}
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
		for (Titre titre : titres) {
			titre = titre.titreToDto();
			titres.add(titre);
		}
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

	
	/*****************************************************************************
	 * Cette partie concerne les Compteurs et aura toutes les méthodes relatives *
	 *****************************************************************************/
	
	public Compteurs getAllCompteurParId() {
		Compteurs compteurs = daoListe.getAllCompteurParId();
		for (Compteur compteur : compteurs) {
			compteur = compteur.cptToDto();
			compteurs.add(compteur);
		}
		return compteurs;
	}

	public Compteur getCompteurParRef(int ref) {
		Compteur compteur = null;
		try {
			compteur = daoListe.getCompteurParRef(ref);
		} catch (DaoException e) {
			System.out.println("!!!!! DM Erreur : " + e.getCode() + ":" + e.getMessage());
		}
		return compteur.cptToDto();
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
