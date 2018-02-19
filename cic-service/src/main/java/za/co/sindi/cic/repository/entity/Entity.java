/**
 * 
 */
package za.co.sindi.cic.repository.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author buhake.sindi
 * @since 2017/08/17
 *
 */
@javax.persistence.Entity
@Table(name="ENTITIES")
@Cacheable
@Access(AccessType.FIELD)
public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 363989070878146434L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	@Access(AccessType.PROPERTY)
	private long entityId;
	
	@Column(name="NAME", nullable=false)
	@Access(AccessType.PROPERTY)
	private String entityName;
	
	@Column(name="EMAIL_ADDRESS", nullable=false, unique=true)
	@Access(AccessType.PROPERTY)
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
