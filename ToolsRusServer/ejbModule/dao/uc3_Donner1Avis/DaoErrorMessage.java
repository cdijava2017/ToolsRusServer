package dao.uc3_Donner1Avis;

import java.io.Serializable;

public enum DaoErrorMessage implements Serializable {
	
	
	ERR_INSERT				(10,"** Erreur sur méthode ajouter **"),		
	ERR_UPDATE				(15,"** Erreur sur méthode modifCommentaire **"), 			
	ERR_DELETE				(20,"** Erreur sur méthode supprimerAll **"), 
	ERR_DELETE_BY_REF		(21,"** Erreur sur méthode supprimerParId **"),
	ERR_NULL				( 0,"** L'objet est null **"),   				
	ERR_COMM_INEXISTANT		( 1,"** Ce commentaire n'existe pas **"), 
	ERR_TITRE_INEXISTANT	( 2,"** Ce commentaire n'existe pas **"), 
	ERR_COMPTEUR_INEXISTANT	( 3,"** Ce commentaire n'existe pas **"), 
	ERR_LISTE_VIDE			( 4,"** La liste est vide **"),
	;	
	
	private int 	code;
	private String 	message;
	
	private DaoErrorMessage(int code, String message) {
		this.code    = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return code + "-" + message;
	}
}
