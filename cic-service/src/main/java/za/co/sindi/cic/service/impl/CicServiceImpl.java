/**
 * 
 */
package za.co.sindi.cic.service.impl;

import java.util.List;
import java.util.function.Function;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import za.co.sindi.cic.repository.entity.Cic;
import za.co.sindi.cic.repository.entity.Entity;
import za.co.sindi.cic.service.CicService;
import za.co.sindi.cic.service.dto.CicDto;
import za.co.sindi.cic.service.dto.EntityDto;
import za.co.sindi.cic.service.exception.NoSuchCicException;
import za.co.sindi.cic.service.exception.ServiceException;

/**
 * @author buhake.sindi
 *
 */
@Stateless
public class CicServiceImpl implements CicService {
	
	@PersistenceContext(name="cicPu")
	private EntityManager entityManager;
	
	private Function<CicDto, Cic> mapToEntity() {
		
		return new Function<CicDto, Cic>() {

			@Override
			public Cic apply(CicDto cicDto) {
				// TODO Auto-generated method stub
				if (cicDto == null) {
					return null;
				}
				
				Cic cic = new Cic();
				cic.setBody(cicDto.getBody());
				cic.setCicId(cicDto.getCicId());
				cic.setCicTimestamp(cicDto.getCicTimestamp());
				cic.setCicType(cicDto.getCicType());
				cic.setSourceSystem(cicDto.getSourceSystem());
				cic.setSubject(cicDto.getSubject());
				cic.setEntity(new Entity());
				cic.getEntity().setEmailAddress(cicDto.getEntity().getEmailAddress());
				cic.getEntity().setEntityId(cicDto.getEntity().getEntityId());
				cic.getEntity().setEntityName(cicDto.getEntity().getEntityName());
				
				return cic;
			}
		};
	}
	
	private Function<Cic, CicDto> mapToDto() {
		
		return new Function<Cic, CicDto>() {

			@Override
			public CicDto apply(Cic cic) {
				// TODO Auto-generated method stub
				if (cic == null) {
					return null;
				}
				
				CicDto cicDto = new CicDto();
				cicDto.setBody(cic.getBody());
				cicDto.setCicId(cic.getCicId());
				cicDto.setCicTimestamp(cic.getCicTimestamp());
				cicDto.setCicType(cic.getCicType());
				cicDto.setSourceSystem(cic.getSourceSystem());
				cicDto.setSubject(cic.getSubject());
				cicDto.setEntity(new EntityDto());
				cicDto.getEntity().setEmailAddress(cic.getEntity().getEmailAddress());
				cicDto.getEntity().setEntityId(cic.getEntity().getEntityId());
				cicDto.getEntity().setEntityName(cic.getEntity().getEntityName());
				
				return cicDto;
			}
		};
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.cic.service.CicService#createNewCic(za.co.sindi.cic.service.dto.CicDto)
	 */
	@Override
	public long createNewCic(CicDto cicDto) throws ServiceException {
		// TODO Auto-generated method stub
		Cic cic = mapToEntity().apply(cicDto);
		List<Entity> entities = entityManager.createQuery("SELECT e From Entity e WHERE e.emailAddress = ?1", Entity.class).setParameter(1, cic.getEntity().getEmailAddress()).getResultList();
		if (entities != null && !entities.isEmpty()) {
			cic.setEntity(entities.get(0));
		}
		entityManager.persist(cic);
		return cic.getCicId();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.cic.service.CicService#getCic(long)
	 */
	@Override
	public CicDto getCic(long cicId) throws ServiceException {
		// TODO Auto-generated method stub
		Cic cic = entityManager.find(Cic.class, cicId);
		if (cic == null) {
			throw new NoSuchCicException();
		}
		
		return mapToDto().apply(cic);
	}
}
