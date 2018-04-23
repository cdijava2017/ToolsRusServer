package clientServer;

import java.util.ArrayList;

import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireException;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.CompteurException;
import entity.uc3_Donner1Avis.compteur.Compteurs;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.TitreException;

public interface IFacade {

	/**
	 * <p>Partie de l'interface groupe qui fait référence aux méthodes de l'UC3 - Donner un avis (commenter).</p>
	 * <p>Ici seront listées toutes les méthodes utilisées par les services Gestion et Liste.</p>
	 * @param commentaire @param titre @param compteur @param ref
	 * 
	 * @throws CommentaireException @throws TitreException @throws CompteurException
	 * @author Nacer ATOUT
	 */

	public Commentaire addCommentaire(Commentaire commentaire) throws CommentaireException;
	public Titre addTitre(Titre titre) throws TitreException;
	public Compteur addCompteur(Compteur compteur) throws CompteurException;

	public void supAllCommentaires() throws CommentaireException;
	public void supCommParId(int idComm) throws CommentaireException;
	public void supAllTitres();
	public void supAllCompteurs();

	public ArrayList<Commentaire> getAllCommParId() throws CommentaireException;
	public ArrayList<Titre> getAllTitreParId();
	public Compteurs getAllCompteurParId();

	public Commentaire getCommParRef(int ref) throws CommentaireException;
	public Titre getTitreParRef(int ref);
	public Compteur getCompteurParRef(int ref);

	public void modifCommentaire(Commentaire commentaire) throws CommentaireException;
	public void modifTitre(Titre titre);
	public void modifCompteur(Compteur compteur);
	public void incrementCompteur(int idCompteur);

}
