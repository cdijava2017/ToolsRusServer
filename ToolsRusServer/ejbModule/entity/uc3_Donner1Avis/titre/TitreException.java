package entity.uc3_Donner1Avis.titre;


public class TitreException extends Exception {

	private static final long serialVersionUID = 1L;

	private int code;
	
	public TitreException() {	}
	
	public TitreException(String message) {
		super(message);
	}

	public TitreException(String message, int code) {
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
