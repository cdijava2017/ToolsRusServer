package clientServer;

import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireVideException;
import entity.uc3_Donner1Avis.commentaire.Commentaires;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.CompteurVideException;
import entity.uc3_Donner1Avis.compteur.Compteurs;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.TitreVideException;
import entity.uc3_Donner1Avis.titre.Titres;

public interface IFacade {

	public Commentaire addCommentaire(Commentaire comm) throws CommentaireVideException;
	public Titre addTitre(Titre titre) throws TitreVideException;
	public Compteur addCompteur(Compteur compteur) throws CompteurVideException;
	
	public void supAllCommentaires();
	public void supAllTitres();
	public void supAllCompteurs();
	
	public Commentaires getAllCommParId();
	public Titres getAllTitreParId();
	public Compteurs getAllCompteurParId();
	
	public Commentaire getCommParRef(int ref);
	public Titre getTitreParRef(int ref);
	public Compteur getCompteurParRef(int ref);
	
	public void modifCommentaire(Commentaire commentaire);
	public void modifTitre(Titre titre);
	public void modifCompteur(Compteur compteur);
	
}
