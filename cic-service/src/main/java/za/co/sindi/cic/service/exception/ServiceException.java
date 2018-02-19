/**
 * 
 */
package za.co.sindi.cic.service.exception;

import javax.ejb.ApplicationException;

/**
 * @author buhake.sindi
 * @since 2016/01/22
 *
 */
@ApplicationException(rollback=true)
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8221903110640730201L;

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
