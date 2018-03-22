package services;


import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.Commentaires;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.Titres;
import services.uc3_Donner1Avis.Uc3Facade;

/**
 * facade principale du projet serveur
 * @author Stag
 *
 */

@Stateless
@Remote(clientServer.IFacade.class)
public class Facade implements clientServer.IFacade{

	@EJB Uc3Facade uc3Facade;
	
	public Facade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Commentaire addCommentaire(Commentaire comm) {
		return uc3Facade.addCommentaire(comm);
	}
	@Override
	public Titre addTitre(Titre titre) {
		return uc3Facade.addTitre(titre);
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
	public Commentaires getAllCommParId() {
		return uc3Facade.getAllCommParId();
	}
	@Override
	public Titres getAllTitreParId() {
		return uc3Facade.getAllTitreParId();
	}

	@Override
	public Commentaire getCommParRef(int ref) {
		return uc3Facade.getCommParRef(ref);
	}
	@Override
	public Titre getTitreParRef(int ref) {
		return uc3Facade.getTitreParRef(ref);
	}


}
