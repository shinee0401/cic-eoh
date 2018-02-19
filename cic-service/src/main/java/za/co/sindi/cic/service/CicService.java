/**
 * 
 */
package za.co.sindi.cic.service;

import za.co.sindi.cic.service.dto.CicDto;
import za.co.sindi.cic.service.exception.ServiceException;

/**
 * @author buhake.sindi
 * @since 2017/08/17
 *
 */
public interface CicService {

	public long createNewCic(final CicDto cic) throws ServiceException;
	public CicDto getCic(final long cicId) throws ServiceException;
}
