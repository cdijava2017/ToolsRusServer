package entity.uc3_Donner1Avis.commentaire;

import dao.uc3_Donner1Avis.DaoErrorMessage;
import dao.uc3_Donner1Avis.DaoException;

public class CommentaireException extends DaoException {

	private static final long serialVersionUID = 1L;

	public CommentaireException() {	}
	
	public CommentaireException(String message) {
		super(message);
	}

	public CommentaireException(DaoErrorMessage errListeVide) {
		super(errListeVide);
	}

}
