package no.arkitektum.kommit.n5.model;

import java.util.List;

public class Arkiv extends Arkivenhet{
	public String tittel;
	public String beskrivelse;		
	public List<Arkivdel> arkivdel;
	
	public Arkiv(String systemID, String tittel, String beskrivelse,
			List<Arkivdel> arkivdel) {
		super(systemID);
		this.tittel = tittel;
		this.beskrivelse = beskrivelse;
		this.arkivdel = arkivdel;
	}
}