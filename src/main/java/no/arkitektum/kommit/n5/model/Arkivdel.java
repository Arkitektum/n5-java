package no.arkitektum.kommit.n5.model;

import java.util.List;

public class Arkivdel extends Arkivenhet{
	public String tittel;
    public List<Mappe> mappe;
    public Arkiv arkiv;
        
	public Arkivdel(String systemID, String tittel, List<Mappe> mappe) {
		super(systemID);
		this.tittel = tittel;
		this.mappe = mappe;
	}      
    
}
