package no.arkitektum.kommit.n5;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

public abstract class Resource {
	protected @Context UriInfo uriInfo;
	
	protected String GetBaseUri() {
		return uriInfo.getBaseUri().toString();
	}
}
