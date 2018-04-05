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
		return uc3Facade.addCommentaire(comm);
	}
	@Override
	public Titre addTitre(Titre titre) throws TitreVideException {
		return uc3Facade.addTitre(titre);
	}
	@Override
	public Compteur addCompteur(Compteur compteur) throws CompteurVideException {
		System.out.println("addCompteur Facade");
		return uc3Facade.addCompteur(compteur);
	}
	@Override
	public void supAllCommentaires() {
		uc3Facade.supAllCommentaires();
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
	public Commentaires getAllCommParId() {
		return uc3Facade.getAllCommParId();
	}
	@Override
	public Titres getAllTitreParId() {
		return uc3Facade.getAllTitreParId();
	}
	@Override
	public Compteurs getAllCompteurParId() {
		return uc3Facade.getAllCompteurParId();
	}
	@Override
	public Commentaire getCommParRef(int ref) {
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
	public void modifCommentaire(Commentaire commentaire) {
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


}
