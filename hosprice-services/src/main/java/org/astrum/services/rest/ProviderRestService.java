package org.astrum.services.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.astrum.common.domain.Provider;
import org.astrum.common.services.ProviderService;
import org.astrum.services.rest.model.ProviderModel;
import org.springframework.stereotype.Component;

@Component
@Path("/provider")
public class ProviderRestService {

	@Inject 
	ProviderService providerService;
	
	
	@Path("/hospital")
	@Produces("application/json")
	@GET
	public Response getProviderByZipcode(@QueryParam("zipcode") String zipcode, @QueryParam("state") String state, @QueryParam("city") String city, @QueryParam("hospital") String hospital, @QueryParam("diagnosis") String diagnosis ){
		List<ProviderModel> pms = null;
		try{
			List <Provider> ps = providerService.getProvidersByZipcode(zipcode);
			pms = ProviderModel.convertToModel(ps);
		}
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity("An error occurred while retreiving data.").build();
		}
		return Response.status(200).entity(pms).build();
	}
	
	@Path("/all")
	@Produces("application/json")
	@GET
	public Response getAllProviders (){
		List<ProviderModel> pms = null;
		try{
			List <Provider> ps = providerService.findAll();
			pms = ProviderModel.convertToModel(ps);
		}
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity("An error occurred while retreiving data.").build();
		}
		return Response.status(200).entity(pms).build();
	}
	
}
