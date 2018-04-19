package entity.uc3_Donner1Avis.compteur;


public class CompteurException extends Exception {

	private static final long serialVersionUID = 1L;

	private int code;
	
	public CompteurException() {	}
	
	public CompteurException(String message) {
		super(message);
	}

	public CompteurException(String message, int code) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
