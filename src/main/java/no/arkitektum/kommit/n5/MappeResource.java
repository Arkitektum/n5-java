package no.arkitektum.kommit.n5;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import no.arkitektum.kommit.n5.model.Mappe;
import no.arkitektum.kommit.n5.representation.MappeRepresentation;

@Path("/mappe/")
public class MappeResource extends Resource {
	private ArkivService arkivService;
	
	public MappeResource() {
		arkivService = new ArkivService();
	}
	
	@Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") String id) {
    	Mappe mappe = arkivService.GetMappe(id);
    	if (mappe != null) {
    		MappeRepresentation mappeRepresentation = new MappeRepresentation(GetBaseUri(), mappe);
        	
    		return Response.ok().entity(mappeRepresentation).build();
    	} else {
    		return Response.status(Status.NOT_FOUND).build();
    	}
	}
}
