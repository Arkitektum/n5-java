package no.arkitektum.kommit.n5;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import no.arkitektum.kommit.n5.model.Arkivdel;
import no.arkitektum.kommit.n5.representation.ArkivdelRepresentation;
import no.arkitektum.kommit.n5.representation.MappeRepresentation;

@Path("/arkivdel/")
public class ArkivdelResource extends Resource {
	
	private ArkivService arkivService;
	
	public ArkivdelResource() {
		arkivService = new ArkivService();		
	}
	
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") String id) {
    	Arkivdel arkivdel = arkivService.GetArkivdel(id);
    	if (arkivdel != null) {
    		ArkivdelRepresentation arkivdelRepresentation = new ArkivdelRepresentation(GetBaseUri(), arkivdel);
        	
    		return Response.ok().entity(arkivdelRepresentation).build();
    	} else {
    		return Response.status(Status.NOT_FOUND).build();
    	}
	}

    @Path("{id}/mapper/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMapperForArkivdel(@PathParam("id") String id) {
    	Arkivdel arkivdel = arkivService.GetArkivdel(id);
    	if (arkivdel != null) {
    		List<MappeRepresentation> mapper = MappeRepresentation.createFromList(GetBaseUri(), arkivdel.mappe);
    		return Response.ok().entity(mapper).build();
    	} else {
    		return Response.status(Status.NOT_FOUND).build();
    	}
    }
    
}
