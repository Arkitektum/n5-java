package no.arkitektum.kommit.n5.model;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
public class Arkivskaper {
	public String arkivskaperID;
	public String arkivskaperNavn;
	public String beskrivelse;
	
	public Arkivskaper() {
		
	}
	
	public Arkivskaper(String arkivskaperID, String arkivskaperNavn,
			String beskrivelse) {
		this.arkivskaperID = arkivskaperID;
		this.arkivskaperNavn = arkivskaperNavn;
		this.beskrivelse = beskrivelse;
	}
	
	
}
