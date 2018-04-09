package exception.uc4;

public class UserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userExceptionMsg;
	
	public UserException() {}

	public UserException(String userExceptionMsg) {
		super();
		this.userExceptionMsg = userExceptionMsg;
	}

	public String getUserExceptionMsg() {
		return userExceptionMsg;
	}

	public void setUserExceptionMsg(String userExceptionMsg) {
		this.userExceptionMsg = userExceptionMsg;
	}
	
	

}
