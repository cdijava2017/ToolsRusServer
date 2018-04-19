package dao.uc3_Donner1Avis;


public class DaoException extends Exception  {

	private static final long serialVersionUID = 1L;
	
	private int code;

	public DaoException() {	}
	
	public DaoException(int code) {
		super();
		this.code = code;
	}

	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(String message, int code) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return super.getMessage();
	}

}
