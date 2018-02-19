/**
 * 
 */
package za.co.sindi.cic.service.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author buhake.sindi
 *
 */
@XmlRootElement(name="cic")
@XmlAccessorType(XmlAccessType.FIELD)
public class CicDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7688396597515833014L;

	@XmlElement(name="id")
	private long cicId;
	
	@XmlElement(name="type")
	private String cicType;
	
	@XmlElement
	private String subject;
	
	@XmlElement
	private String body;
	
	@XmlElement
	private String sourceSystem;
	
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date cicTimestamp;
	
	@XmlElement
	private EntityDto entity;

	public long getCicId() {
		return cicId;
	}

	public void setCicId(long cicId) {
		this.cicId = cicId;
	}

	public String getCicType() {
		return cicType;
	}

	public void setCicType(String cicType) {
		this.cicType = cicType;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public Date getCicTimestamp() {
		return cicTimestamp;
	}

	public void setCicTimestamp(Date cicTimestamp) {
		this.cicTimestamp = cicTimestamp;
	}

	public EntityDto getEntity() {
		return entity;
	}

	public void setEntity(EntityDto entity) {
		this.entity = entity;
	}
}
