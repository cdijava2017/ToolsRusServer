package dao.uc3_Donner1Avis;

public enum DaoErrorMessage {
	
	ERR_INSERT			(10,"**DM** Erreur insert"),		
	ERR_UPDATE			(15,"**DM** Erreur update"), 			
	ERR_DELETE			(20,"**DM** Erreur delete"), 
	ERR_DELETE_BY_REF	(21,"**DM** Erreur delCalculByRef"),
	ERR_NULL			( 0,"**DM** Le calcul est null"),   				
	ERR_INEXISTANT		( 1,"**DM** Le commentaire n'existe pas"), 
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
