package no.arkitektum.kommit.n5.model;

import java.util.List;

public class Mappe extends Arkivenhet{
	public String mappeID;
    public String tittel;
    public List<Registrering> registrering;
    
	public Mappe(String systemID, String mappeID, String tittel,
			List<Registrering> registrering) {
		super(systemID);
		this.mappeID = mappeID;
		this.tittel = tittel;
		this.registrering = registrering;
	}
       
}
