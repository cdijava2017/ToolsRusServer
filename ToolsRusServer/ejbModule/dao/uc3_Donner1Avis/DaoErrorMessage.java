package dao.uc3_Donner1Avis;

public enum DaoErrorMessage {
	
	ERR_INSERT			(10,"**DM** Erreur ajouter"),		
	ERR_UPDATE			(15,"**DM** Erreur modifCommentaire"), 			
	ERR_DELETE			(20,"**DM** Erreur supprimerAll"), 
	ERR_DELETE_BY_REF	(21,"**DM** Erreur supprimerParId"),
	ERR_NULL			( 0,"**DM** L'objet est null"),   				
	ERR_INEXISTANT		( 1,"** Attention, ceci n'existe pas encore **"), 
	ERR_LISTE_VIDE		( 2,"** Attention, la liste est vide **"),
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
