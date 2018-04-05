package clientServer.uc06Cafe;

public class UserException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String codeErreur;
	
	public UserException() {
		super();
	}

	public UserException (String codeErreur) {
		super();
		this.codeErreur = codeErreur;
	}
	
	public UserException (String message, String codeErreur) {
		super (message);
		this.codeErreur = codeErreur;
	}
	
	public UserException (Throwable cause, String codeErreur) {
		super (cause);
		this.codeErreur = codeErreur;
	}
	
	
	public UserException (String message, Throwable cause, String codeErreur) {
		super (message, cause);
		this.codeErreur = codeErreur;
	}
	
	public String getCodeErreur () {
		return codeErreur;
	}

	// TODO
	// A voir si besoin de seter mon codeErreur a un moment ?
//	public void setCodeErreur(String codeErreur) {
//		this.codeErreur = codeErreur;
//	}
	
	public String getMessage() {
		return super.getMessage();
	}
	
	
	
	
}
