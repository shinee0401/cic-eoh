/**
 * 
 */
package za.co.sindi.cic.repository.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author buhake.sindi
 * @since 2017/08/17
 *
 */
@Entity
@Table(name="CICS")
@Cacheable
@Access(AccessType.FIELD)
public class Cic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8859833304544887154L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	@Access(AccessType.PROPERTY)
	private long cicId;
	
	@Column(name="TYPE", nullable=false)
	@Access(AccessType.PROPERTY)
	private String cicType;
	
	@Column(name="SUBJECT", nullable=false)
	@Access(AccessType.PROPERTY)
	private String subject;
	
	@Column(name="BODY", nullable=false)
	@Access(AccessType.PROPERTY)
	private String body;
	
	@Column(name="SOURCE_SYSTEM", nullable=false)
	@Access(AccessType.PROPERTY)
	private String sourceSystem;
	
	@Column(name="CIC_TIMESTAMP", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@Access(AccessType.PROPERTY)
	private Date cicTimestamp;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ENTITY_ID", nullable=false)
	private za.co.sindi.cic.repository.entity.Entity entity;

	/**
	 * @return the cicId
	 */
	public long getCicId() {
		return cicId;
	}

	/**
	 * @param cicId the cicId to set
	 */
	public void setCicId(long cicId) {
		this.cicId = cicId;
	}

    public void updateCICId(long prevId)
    {
        this.cicId = prevId;
    }
	/**
	 * @return the cicType
	 */
	public String getCicType() {
		return cicType;
	}

	/**
	 * @param cicType the cicType to set
	 */
	public void setCicType(String cicType) {
		this.cicType = cicType;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the sourceSystem
	 */
	public String getSourceSystem() {
		return sourceSystem;
	}

	/**
	 * @param sourceSystem the sourceSystem to set
	 */
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	/**
	 * @return the cicTimestamp
	 */
	public Date getCicTimestamp() {
		return cicTimestamp;
	}

	/**
	 * @param cicTimestamp the cicTimestamp to set
	 */
	public void setCicTimestamp(Date cicTimestamp) {
		this.cicTimestamp = cicTimestamp;
	}

	public za.co.sindi.cic.repository.entity.Entity getEntity() {
		return entity;
	}

	public void setEntity(za.co.sindi.cic.repository.entity.Entity entity) {
		this.entity = entity;
	}

	public void updateEntity(za.co.sindi.cic.repository.entity.Entity entity){
		this.entity = entity;
	}
}
