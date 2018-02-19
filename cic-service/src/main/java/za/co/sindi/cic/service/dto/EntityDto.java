/**
 * 
 */
package za.co.sindi.cic.service.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author buhake.sindi
 * @since 2017/08/17
 *
 */
@XmlRootElement(name="entity")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntityDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8091019955938536774L;

	@XmlElement(name="id")
	private long entityId;
	
	@XmlElement(name="name")
	private String entityName;
	
	@XmlElement
	private String emailAddress;

	/**
	 * @return the entityId
	 */
	public long getEntityId() {
		return entityId;
	}

	/**
	 * @param entityId the entityId to set
	 */
	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * @param entityName the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}	
}
