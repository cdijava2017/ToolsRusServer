package dao.uc3_Donner1Avis;

public enum DaoErrorMessage {
	
	ERR_INSERT			(10,"** Erreur sur méthode ajouter **"),		
	ERR_UPDATE			(15,"** Erreur sur méthode modifCommentaire **"), 			
	ERR_DELETE			(20,"** Erreur sur méthode supprimerAll **"), 
	ERR_DELETE_BY_REF	(21,"** Erreur sur méthode supprimerParId **"),
	ERR_NULL			( 0,"** L'objet est null **"),   				
	ERR_INEXISTANT		( 1,"** L'objet n'existe pas encore **"), 
	ERR_LISTE_VIDE		( 2,"** La liste est vide **"),
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
