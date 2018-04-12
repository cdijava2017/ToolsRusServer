package services.uc3_Donner1Avis;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireVideException;
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

	
	/**
	 * <p> Méthodes pour ajouter en Base de Données.</p>
	 * <p> On reçoit en paramètre un objet à persister et on retourne le même objet traité (en DTO) et utilisable dans des listes. </p>
	 * @param commentaire @param titre @param compteur @param ref
	 * @return commentaire @return titre @return compteur
	 * @throws CommentaireVideException @throws TitreVideException @throws CompteurVideException
	 * @author Nacer ATOUT
	 */
	
	public Commentaire addCommentaire(Commentaire commentaire) throws CommentaireVideException {
		commentaire = gestion.creerComm(commentaire);
		return commentaire;
	}

	public Titre addTitre(Titre titre) throws TitreVideException {
		return gestion.creerTitre(titre);
	}

	public Compteur addCompteur(Compteur compteur) throws CompteurVideException {
		return gestion.creerCompteur(compteur);
	}
	
	
	/**
	 * <p> Méthodes pour supprimer en Base de Données. On supprime tout dans la table correspondante.</p>
	 * @author Nacer ATOUT
	 */
	
	public void supAllCommentaires() {
		gestion.supAllCommentaires();
	}
	
	public void supCommParId(Commentaire commentaire) {
		gestion.supCommParId(commentaire);
	}

	public void supAllTitres() {
		gestion.supAllTitres();
	}

	public void supAllCompteurs() {
		gestion.supAllCompteurs();
	}
	
	
	/**
	 * <p> Méthodes pour lister les données stockées en Base de Données</p>
	 * <p> On récupère tout ce qui se trouve dans une table et on le met dans une ArrayList pour pouvoir le traiter au besoin.</p>
	 * @return liste.getAllCommParId() @return liste.getAllTitreParId() @return liste.getAllCompteurParId()
	 * @author Nacer ATOUT
	 */
	
	public ArrayList<Commentaire> getAllCommParId() {
		ArrayList<Commentaire> commentaires = liste.getAllCommParId();
		return commentaires;
	}

	public Titres getAllTitreParId() {
		return liste.getAllTitreParId();
	}

	public Compteurs getAllCompteurParId() {
		return liste.getAllCompteurParId();
	}
	
	
	/**
	 *<p> Méthodes pour lister individuellement les données stockées en Base de Données depuis leur référence (ID).</p>
	 *<p> Elles recoivent en paramètre un chiffre qui correspond à l'ID de l'objet qu'on veut récupérer en base et afficher.</p>
	 * @param ref
	 * @return liste.getCommParRef() @return liste.getTitreParRef() @return liste.getCompteurParRef()
	 * @author Nacer ATOUT
	 */
	
	public Commentaire getCommParRef(int ref) {
		return liste.getCommParRef(ref);
	}

	public Titre getTitreParRef(int ref) {
		return liste.getTitreParRef(ref);
	}
	
	public Compteur getCompteurParRef(int ref) {
		return liste.getCompteurParRef(ref);
	}
	
	
	/**
	 * <p> Méthodes pour modifier en Base de Données.</p>
	 * <p> Ces méthodes remplacent en mémoire les objets stockés par hibernate 
	 * par celui qu'on leur transmet en paramètre avant de les persister.</p>
	 * @param commentaire @param titre @param compteur
	 * @author Nacer ATOUT
	 */
	
	public void modifCommentaire(Commentaire commentaire) {
		gestion.modifCommentaire(commentaire);
	}

	public void modifTitre(Titre titre) {
		gestion.modifTitre(titre);
	}

	public void modifCompteur(Compteur compteur) {
		gestion.modifCompteur(compteur);
	}

	public void incrementCompteur(Compteur compteur) {
		gestion.incrementCompteur(compteur);
	}
	

}
