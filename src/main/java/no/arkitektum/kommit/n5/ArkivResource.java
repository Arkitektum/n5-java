package no.arkitektum.kommit.n5;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import no.arkitektum.kommit.n5.model.Arkiv;
import no.arkitektum.kommit.n5.representation.ArkivRepresentation;
import no.arkitektum.kommit.n5.representation.ArkivdelRepresentation;

@Path("/arkiv/")
public class ArkivResource extends Resource {
	
	private ArkivService arkivService;
	
	public ArkivResource() {
		arkivService = new ArkivService();		
	}
	
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") String id) {
    	Arkiv arkiv = arkivService.GetArkiv(id);
    	if (arkiv != null) {
    		ArkivRepresentation arkivRepresentation = new ArkivRepresentation(GetBaseUri(), arkiv);
        	
    		return Response.ok().entity(arkivRepresentation).build();
    	} else {
    		return Response.status(Status.NOT_FOUND).build();
    	}
	}
    
    @Path("{id}/arkivdeler/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArkivdelerForArkiv(@PathParam("id") String id) {
    	Arkiv arkiv = arkivService.GetArkiv(id);
    	if (arkiv != null) {
    		List<ArkivdelRepresentation> arkivdeler = ArkivdelRepresentation.createFromList(GetBaseUri(), arkiv.arkivdel);
    		return Response.ok().entity(arkivdeler).build();
    	} else {
    		return Response.status(Status.NOT_FOUND).build();
    	}
    }
    
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		List<Arkiv> all = arkivService.GetAll();
		
		List<ArkivRepresentation> allRepresentation = ArkivRepresentation.createFromList(GetBaseUri(), all);
		
		return Response.ok().entity(allRepresentation).build();
	}
	

}
