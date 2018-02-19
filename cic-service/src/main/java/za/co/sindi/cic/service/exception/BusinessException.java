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
public abstract class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1711008886496487377L;

	/**
	 * 
	 */
	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public BusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
