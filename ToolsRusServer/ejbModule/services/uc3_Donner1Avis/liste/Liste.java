package services.uc3_Donner1Avis.liste;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dao.uc3_Donner1Avis.DaoException;
import dao.uc3_Donner1Avis.DaoListe;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireException;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.Compteurs;
import entity.uc3_Donner1Avis.titre.Titre;



@Singleton
@LocalBean
public class Liste {

	@EJB private DaoListe daoListe;


	/*******************************************************************************
	 * Cette partie concerne les Commentaires et aura toutes les méthodes relatives*
	 *******************************************************************************/
	
	public ArrayList<Commentaire> getAllCommParId() throws CommentaireException {
		ArrayList<Commentaire> recup = daoListe.getAllCommParId();
		ArrayList<Commentaire> comms = new ArrayList<Commentaire>();
		for (Commentaire comm : recup) {
			Commentaire commDto = comm.commToDto();
			comms.add(commDto);
		}
		return comms;
	}

	public Commentaire getCommParRef(int ref) throws CommentaireException {
		Commentaire commentaire = null;
		try {
			commentaire = daoListe.getCommParRef(ref);
		} catch (DaoException e) {
			System.out.println(e);
			throw new CommentaireException(e.getMessage());
		}
		return commentaire;
	}


	/*************************************************************************
	 * Cette partie concerne les Titres et aura toutes les méthodes relatives*
	 *************************************************************************/
	
	public ArrayList<Titre> getAllTitreParId() {
		ArrayList<Titre> titres = daoListe.getAllTitreParId();
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


}
