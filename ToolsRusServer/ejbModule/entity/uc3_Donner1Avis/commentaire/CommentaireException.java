package entity.uc3_Donner1Avis.commentaire;

import dao.uc3_Donner1Avis.DaoErrorMessage;
import dao.uc3_Donner1Avis.DaoException;

public class CommentaireException extends DaoException {

	public CommentaireException(String message) {
		super(message);
	}

	public CommentaireException(DaoErrorMessage errListeVide) {
		super(errListeVide);
	}

	private static final long serialVersionUID = 1L;

}
