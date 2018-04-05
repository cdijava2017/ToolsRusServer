package services.uc3_Donner1Avis;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireVideException;
import entity.uc3_Donner1Avis.commentaire.Commentaires;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.CompteurVideException;
import entity.uc3_Donner1Avis.compteur.Compteurs;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.TitreVideException;
import entity.uc3_Donner1Avis.titre.Titres;
import services.uc3_Donner1Avis.gestion.Gestion;
import services.uc3_Donner1Avis.liste.Liste;


@LocalBean
@Singleton
public class Uc3Facade {

	@EJB private Gestion gestion;
	@EJB private Liste liste;

	
	// Ajouter en BdD
	public Commentaire addCommentaire(Commentaire comm) throws CommentaireVideException {
		return gestion.creerComm(comm);
	}

	public Titre addTitre(Titre titre) throws TitreVideException {
		return gestion.creerTitre(titre);
	}

	public Compteur addCompteur(Compteur compteur) throws CompteurVideException {
		System.out.println("addCompteur UC3Facade");
		return gestion.creerCompteur(compteur);
	}
	
	
	// Supprimer tout
	public void supAllCommentaires() {
		gestion.supAllCommentaires();
	}

	public void supAllTitres() {
		gestion.supAllTitres();
	}

	public void supAllCompteurs() {
		gestion.supAllCompteurs();
	}
	
	
	// Get all
	public Commentaires getAllCommParId() {
		return liste.getAllCommParId();
	}

	public Titres getAllTitreParId() {
		return liste.getAllTitreParId();
	}

	public Compteurs getAllCompteurParId() {
		return liste.getAllCompteurParId();
	}
	
	
	// Get par référence
	public Commentaire getCommParRef(int ref) {
		return liste.getCommParRef(ref);
	}

	public Titre getTitreParRef(int ref) {
		return liste.getTitreParRef(ref);
	}
	
	public Compteur getCompteurParRef(int ref) {
		return liste.getCompteurParRef(ref);
	}
	
	
	// modifier
	public void modifCommentaire(Commentaire commentaire) {
		gestion.modifCommentaire(commentaire);
	}

	public void modifTitre(Titre titre) {
		gestion.modifTitre(titre);
	}

	public void modifCompteur(Compteur compteur) {
		gestion.modifCompteur(compteur);
	}
	

}
