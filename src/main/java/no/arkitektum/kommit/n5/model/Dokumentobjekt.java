package no.arkitektum.kommit.n5.model;

public class Dokumentobjekt extends Arkivenhet {
    public String referanseDokumentfil;

	public Dokumentobjekt(String systemID, String referanseDokumentfil) {
		super(systemID);
		this.referanseDokumentfil = referanseDokumentfil;
	}

    
}
