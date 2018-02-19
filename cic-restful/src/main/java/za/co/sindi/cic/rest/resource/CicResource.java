/**
 * 
 */
package za.co.sindi.cic.rest.resource;

import java.util.logging.Level;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import za.co.sindi.cic.service.CicService;
import za.co.sindi.cic.service.dto.CicDto;
import za.co.sindi.cic.service.exception.ServiceException;

/**
 * @author buhake.sindi
 * @since 2017/08/17
 *
 */
@Path("/cic")
@Produces(MediaType.APPLICATION_JSON)
public class CicResource extends AbstractResource {

	@Inject
	private CicService cicService;
	
	@GET
	@Path("/{cicId:\\d+}")
	public CicDto get(@PathParam("cicId") final long cicId) {
		try {
			return cicService.getCic(cicId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.SEVERE, e.getLocalizedMessage(), e);
			throw toWebApplicationException(e);
		} catch (RuntimeException e) {
			LOGGER.log(Level.SEVERE, e.getLocalizedMessage(), e);
			throw toWebApplicationException(e);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public CicDto post(CicDto cicDto) {
		try {
			return cicService.getCic(cicService.createNewCic(cicDto));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.SEVERE, e.getLocalizedMessage(), e);
			throw toWebApplicationException(e);
		} catch (RuntimeException e) {
			LOGGER.log(Level.SEVERE, e.getLocalizedMessage(), e);
			throw toWebApplicationException(e);
		}
	}
}
