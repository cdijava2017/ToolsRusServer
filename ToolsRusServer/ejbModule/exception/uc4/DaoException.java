package exception.uc4;

public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String daoExceptionMsg;
	
	public DaoException () {}

	public DaoException(String daoExceptionMsg) {
		super();
		this.daoExceptionMsg = daoExceptionMsg;
	}

	public String getDaoExceptionMsg() {
		return daoExceptionMsg;
	}

	public void setDaoExceptionMsg(String daoExceptionMsg) {
		this.daoExceptionMsg = daoExceptionMsg;
	}


	
	

}
