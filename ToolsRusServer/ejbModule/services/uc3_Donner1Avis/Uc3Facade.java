package services.uc3_Donner1Avis;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dao.uc3_Donner1Avis.DaoException;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireException;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.CompteurException;
import entity.uc3_Donner1Avis.compteur.Compteurs;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.TitreException;
import entity.uc3_Donner1Avis.titre.Titres;
import services.uc3_Donner1Avis.gestion.Gestion;
import services.uc3_Donner1Avis.liste.Liste;


@LocalBean
@Singleton
public class Uc3Facade {

	@EJB private Gestion gestion;
	@EJB private Liste liste;


	/**
	 * <p> M�thodes pour ajouter en Base de Donn�es.</p>
	 * <p> On re�oit en param�tre un objet � persister et on retourne le m�me objet trait� (en DTO) et utilisable dans des listes. </p>
	 * @param commentaire @param titre @param compteur @param ref
	 * @return commentaire @return titre @return compteur
	 * @throws CommentaireException @throws TitreVideException @throws CompteurVideException
	 * @author Nacer ATOUT
	 */

	public Commentaire addCommentaire(Commentaire commentaire) throws CommentaireException {
		commentaire = gestion.creerComm(commentaire);
		return commentaire;
	}

	public Titre addTitre(Titre titre) throws TitreException {
		return gestion.creerTitre(titre);
	}

	public Compteur addCompteur(Compteur compteur) throws CompteurException {
		return gestion.creerCompteur(compteur);
	}


	/**
	 * <p> M�thodes pour supprimer en Base de Donn�es. On supprime tout dans la table correspondante.</p>
	 * @author Nacer ATOUT
	 * @throws CommentaireException 
	 */

	public void supAllCommentaires() throws CommentaireException {
		gestion.supAllCommentaires();
	}

	public void supCommParId(int idComm) throws CommentaireException  {
		gestion.supCommParId(idComm);
	}

	public void supAllTitres() {
		gestion.supAllTitres();
	}

	public void supAllCompteurs() {
		gestion.supAllCompteurs();
	}


	/**
	 * <p> M�thodes pour lister les donn�es stock�es en Base de Donn�es</p>
	 * <p> On r�cup�re tout ce qui se trouve dans une table et on le met dans une ArrayList pour pouvoir le traiter au besoin.</p>
	 * @return liste.getAllCommParId() @return liste.getAllTitreParId() @return liste.getAllCompteurParId()
	 * @author Nacer ATOUT
	 * @throws DaoException 
	 */

	public ArrayList<Commentaire> getAllCommParId() throws CommentaireException {
		ArrayList<Commentaire> commentaires = liste.getAllCommParId();
		return commentaires;
	}

	public ArrayList<Titre> getAllTitreParId() {
		return liste.getAllTitreParId();
	}

	public Compteurs getAllCompteurParId() {
		return liste.getAllCompteurParId();
	}


	/**
	 *<p> M�thodes pour lister individuellement les donn�es stock�es en Base de Donn�es depuis leur r�f�rence (ID).</p>
	 *<p> Elles recoivent en param�tre un chiffre qui correspond � l'ID de l'objet qu'on veut r�cup�rer en base et afficher.</p>
	 * @param ref
	 * @return liste.getCommParRef() @return liste.getTitreParRef() @return liste.getCompteurParRef()
	 * @author Nacer ATOUT
	 * @throws DaoException 
	 */

	public Commentaire getCommParRef(int ref) throws CommentaireException {
		return liste.getCommParRef(ref);
	}

	public Titre getTitreParRef(int ref) {
		return liste.getTitreParRef(ref);
	}

	public Compteur getCompteurParRef(int ref) {
		return liste.getCompteurParRef(ref);
	}


	/**
	 * <p> M�thodes pour modifier en Base de Donn�es.</p>
	 * <p> Ces m�thodes remplacent en m�moire les objets stock�s par hibernate 
	 * par celui qu'on leur transmet en param�tre avant de les persister.</p>
	 * @param commentaire @param titre @param compteur
	 * @author Nacer ATOUT
	 */

	public void modifCommentaire(Commentaire commentaire) throws CommentaireException {
		gestion.modifCommentaire(commentaire);
	}

	public void modifTitre(Titre titre) {
		gestion.modifTitre(titre);
	}

	public void modifCompteur(Compteur compteur) {
		gestion.modifCompteur(compteur);
	}

	public void incrementCompteur(int idCompteur) {
		gestion.incrementCompteur(idCompteur);
	}


}
