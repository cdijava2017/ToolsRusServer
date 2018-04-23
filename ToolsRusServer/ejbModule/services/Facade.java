package services;


import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import clientServer.IFacade;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireException;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.CompteurException;
import entity.uc3_Donner1Avis.compteur.Compteurs;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.TitreException;
import services.uc3_Donner1Avis.Uc3Facade;

/**
 * Facade principale du projet serveur
 * @author Groupe
 *
 */

@Stateless
@Remote(IFacade.class)
public class Facade implements IFacade {

	@EJB Uc3Facade uc3Facade;

	public Facade() {}

	/**
	 * M�thodes de l'UC3 - Donner un avis / Commenter
	 */
	@Override
	public Commentaire addCommentaire(Commentaire commentaire) throws CommentaireException {		
		commentaire = uc3Facade.addCommentaire(commentaire);
		return commentaire;
	}
	@Override
	public Titre addTitre(Titre titre) throws TitreException {
		return uc3Facade.addTitre(titre);
	}
	@Override
	public Compteur addCompteur(Compteur compteur) throws CompteurException {
		return uc3Facade.addCompteur(compteur);
	}
	@Override
	public void supAllCommentaires() throws CommentaireException {
		uc3Facade.supAllCommentaires();
	}
	@Override
	public void supCommParId(int idComm) throws CommentaireException  {
		uc3Facade.supCommParId(idComm);
	}
	@Override
	public void supAllTitres() {
		uc3Facade.supAllTitres();
	}
	@Override
	public void supAllCompteurs() {
		uc3Facade.supAllCompteurs();
	}
	@Override
	public ArrayList<Commentaire> getAllCommParId() throws CommentaireException {
		ArrayList<Commentaire> commentaires = uc3Facade.getAllCommParId();
		return commentaires;
	}
	@Override
	public ArrayList<Titre> getAllTitreParId() {
		return uc3Facade.getAllTitreParId();
	}
	@Override
	public Compteurs getAllCompteurParId() {
		return uc3Facade.getAllCompteurParId();
	}
	@Override
	public Commentaire getCommParRef(int ref) throws CommentaireException {
		return uc3Facade.getCommParRef(ref);
	}
	@Override
	public Titre getTitreParRef(int ref) {
		return uc3Facade.getTitreParRef(ref);
	}
	@Override
	public Compteur getCompteurParRef(int ref) {
		return uc3Facade.getCompteurParRef(ref);
	}

	@Override
	public void modifCommentaire(Commentaire commentaire) throws CommentaireException {
		uc3Facade.modifCommentaire(commentaire);
	}
	@Override
	public void modifTitre(Titre titre) {
		uc3Facade.modifTitre(titre);
	}
	@Override
	public void modifCompteur(Compteur compteur) {
		uc3Facade.modifCompteur(compteur);
	}
	@Override
	public void incrementCompteur(int idCompteur) {
		uc3Facade.incrementCompteur(idCompteur);
	}


}
