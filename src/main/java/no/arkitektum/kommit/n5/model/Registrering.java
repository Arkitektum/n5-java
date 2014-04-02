package no.arkitektum.kommit.n5.model;

import java.util.Date;
import java.util.List;

public class Registrering extends Arkivenhet {
	public String opprettetAv;
    public Date opprettetDato;
    public List<Dokumentobjekt> dokumentobjekt;
    
	public Registrering(String systemID, String opprettetAv,
			Date opprettetDato, List<Dokumentobjekt> dokumentobjekt) {
		super(systemID);
		this.opprettetAv = opprettetAv;
		this.opprettetDato = opprettetDato;
		this.dokumentobjekt = dokumentobjekt;
	}
    
    
}
