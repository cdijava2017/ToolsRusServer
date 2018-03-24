package services.uc3_Donner1Avis;

import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireVideException;
import entity.uc3_Donner1Avis.commentaire.Commentaires;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.TitreVideException;
import entity.uc3_Donner1Avis.titre.Titres;
import services.uc3_Donner1Avis.gestion.Gestion;
import services.uc3_Donner1Avis.liste.Liste;

public class Uc3Facade {

	private Gestion gestion;
	private Liste liste;

	// Ajouter en BdD
	public Commentaire addCommentaire(Commentaire comm) throws CommentaireVideException {
		return gestion.creerComm(comm);
	}

	public Titre addTitre(Titre titre) throws TitreVideException {
		return gestion.creerTitre(titre);
	}

	// Supprimer tout
	public void supAllCommentaires() {
		gestion.supAllCommentaires();
	}

	public void supAllTitres() {
		gestion.supAllTitres();
	}

	// Get all
	public Commentaires getAllCommParId() {
		return liste.getAllCommParId();
	}

	public Titres getAllTitreParId() {
		return liste.getAllTitreParId();
	}

	// Get par référence
	public Commentaire getCommParRef(int ref) {
		return liste.getCommParRef(ref);
	}

	public Titre getTitreParRef(int ref) {
		return liste.getTitreParRef(ref);
	}


}
