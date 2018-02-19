/**
 * 
 */
package za.co.sindi.cic.rest.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import za.co.sindi.cic.rest.util.Throwables;

/**
 * @author buhake.sindi
 * @since 2015/08/07
 *
 */
@XmlRootElement(name="exception")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExceptionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7249046529113083616L;

	@XmlElement(name="error_class")
	private String exceptionClassName;
	
	@XmlElement(name="error_message")
	private String exceptionMessage;
	
	@XmlElement(name="error_cause", nillable=true)
	private ExceptionEntity rootCause;

	/**
	 * 
	 */
	public ExceptionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public ExceptionEntity(Throwable throwable) {
		this(throwable, 0, 1);
	}
	
	private ExceptionEntity(Throwable throwable, int startDepth, int maxDepth) {
		super();
		// TODO Auto-generated constructor stub
		if (throwable == null) {
			throw new IllegalArgumentException("No exception/error has been provided.");
		}
		this.exceptionClassName = throwable.getClass().getName();
		this.exceptionMessage = throwable.getLocalizedMessage();
		if (startDepth < maxDepth) {
			Throwable cause = throwable.getCause();
			if (cause != null) {
				Throwable rootCauseException = Throwables.getRootCause(cause);
				if (rootCauseException != null) {
					rootCause = new ExceptionEntity(rootCauseException, startDepth + 1, maxDepth);
				}
			}
		}
	}
	
	/**
	 * @return the exceptionClassName
	 */
	public String getExceptionClassName() {
		return exceptionClassName;
	}

	/**
	 * @param exceptionClassName the exceptionClassName to set
	 */
	public void setExceptionClassName(String exceptionClassName) {
		this.exceptionClassName = exceptionClassName;
	}

	/**
	 * @return the exceptionMessage
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * @param exceptionMessage the exceptionMessage to set
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	/**
	 * @return the rootCause
	 */
	public ExceptionEntity getRootCause() {
		return rootCause;
	}

	/**
	 * @param rootCause the rootCause to set
	 */
	public void setRootCause(ExceptionEntity rootCause) {
		this.rootCause = rootCause;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exceptionClassName == null) ? 0 : exceptionClassName.hashCode());
		result = prime * result + ((exceptionMessage == null) ? 0 : exceptionMessage.hashCode());
		result = prime * result + ((rootCause == null) ? 0 : rootCause.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExceptionEntity other = (ExceptionEntity) obj;
		if (exceptionClassName == null) {
			if (other.exceptionClassName != null)
				return false;
		} else if (!exceptionClassName.equals(other.exceptionClassName))
			return false;
		if (exceptionMessage == null) {
			if (other.exceptionMessage != null)
				return false;
		} else if (!exceptionMessage.equals(other.exceptionMessage))
			return false;
		if (rootCause == null) {
			if (other.rootCause != null)
				return false;
		} else if (!rootCause.equals(other.rootCause))
			return false;
		return true;
	}
}
