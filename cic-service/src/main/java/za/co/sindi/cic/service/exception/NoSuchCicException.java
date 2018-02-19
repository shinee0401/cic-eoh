/**
 * 
 */
package za.co.sindi.cic.service.exception;

/**
 * @author buhake.sindi
 *
 */
public class NoSuchCicException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8398293620222008429L;

	/**
	 * 
	 */
	public NoSuchCicException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NoSuchCicException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public NoSuchCicException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public NoSuchCicException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
