package services;


import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import clientServer.IFacade;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireVideException;
import entity.uc3_Donner1Avis.commentaire.Commentaires;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.CompteurVideException;
import entity.uc3_Donner1Avis.compteur.Compteurs;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.TitreVideException;
import entity.uc3_Donner1Avis.titre.Titres;
import services.uc3_Donner1Avis.Uc3Facade;

/**
 * facade principale du projet serveur
 * @author Groupe
 *
 */

@Stateless
@Remote(IFacade.class)
public class Facade implements IFacade {

	@EJB Uc3Facade uc3Facade;
	
	public Facade() {}

	/**
	 * Méthodes de l'UC3 - Donner un avis / Commenter
	 */
	@Override
	public Commentaire addCommentaire(Commentaire comm) throws CommentaireVideException {
		System.out.println("addCommentaire Facade");
		return uc3Facade.addCommentaire(comm);
	}
	@Override
	public Titre addTitre(Titre titre) throws TitreVideException {
		System.out.println("addTitre Facade");
		return uc3Facade.addTitre(titre);
	}
	@Override
	public Compteur addCompteur(Compteur compteur) throws CompteurVideException {
		System.out.println("addCompteur Facade");
		return uc3Facade.addCompteur(compteur);
	}
	@Override
	public void supAllCommentaires() {
		System.out.println("supAllCommentaires Facade");
		uc3Facade.supAllCommentaires();
	}
	@Override
	public void supAllTitres() {
		System.out.println("supAllTitres Facade");
		uc3Facade.supAllTitres();
	}
	@Override
	public void supAllCompteurs() {
		System.out.println("supAllCompteurs Facade");
		uc3Facade.supAllCompteurs();
	}
	@Override
	public Commentaires getAllCommParId() {
		System.out.println("getAllCommParId Facade");
		return uc3Facade.getAllCommParId();
	}
	@Override
	public Titres getAllTitreParId() {
		System.out.println("getAllTitreParId Facade");
		return uc3Facade.getAllTitreParId();
	}
	@Override
	public Compteurs getAllCompteurParId() {
		System.out.println("getAllCompteurParId Facade");
		return uc3Facade.getAllCompteurParId();
	}
	@Override
	public Commentaire getCommParRef(int ref) {
		System.out.println("getCommParRef Facade");
		return uc3Facade.getCommParRef(ref);
	}
	@Override
	public Titre getTitreParRef(int ref) {
		System.out.println("getTitreParRef Facade");
		return uc3Facade.getTitreParRef(ref);
	}
	@Override
	public Compteur getCompteurParRef(int ref) {
		System.out.println("getCompteurParRef Facade");
		return uc3Facade.getCompteurParRef(ref);
	}
	
	@Override
	public void modifCommentaire(Commentaire commentaire) {
		System.out.println("modifCommentaire Facade");
		uc3Facade.modifCommentaire(commentaire);
	}
	@Override
	public void modifTitre(Titre titre) {
		System.out.println("modifTitre Facade");
		uc3Facade.modifTitre(titre);
	}
	@Override
	public void modifCompteur(Compteur compteur) {
		System.out.println("modifCompteur Facade");
		uc3Facade.modifCompteur(compteur);
	}
	public void incrementerCompteur(Compteur compteur) {
		System.out.println("incrementerCompteur Facade");
		uc3Facade.incrementerCompteur(compteur);
	}

}
