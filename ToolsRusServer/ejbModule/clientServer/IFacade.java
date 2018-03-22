package clientServer;

import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.Commentaires;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.Titres;

public interface IFacade {

	public Commentaire addCommentaire(Commentaire comm);
	public Titre addTitre(Titre titre);
	
	public void supAllCommentaires();
	public void supAllTitres();
	
	public Commentaires getAllCommParId();
	public Titres getAllTitreParId();
	
	public Commentaire getCommParRef(int ref);
	public Titre getTitreParRef(int ref);
	
}
