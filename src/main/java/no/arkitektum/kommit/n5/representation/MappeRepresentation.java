package no.arkitektum.kommit.n5.representation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import no.arkitektum.kommit.n5.model.Mappe;

@XmlRootElement(name = "mappe", namespace = Representation.N5_NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
public class MappeRepresentation extends Representation {
	public String systemID;
	public String mappeID;
    public String tittel;
    
	public MappeRepresentation(String baseUri, Mappe mappe) {
		super(baseUri);
		systemID = mappe.systemID;
		mappeID = mappe.mappeID;
		tittel = mappe.tittel;
		addLink(Representation.SELF_REL_VALUE, pathToSelf());
		addLink("registreringer", pathToSelf() + "/registreringer");
	}

	@Override
	public String pathToSelf() {
		return "mappe/" + systemID;
	}

	public static List<MappeRepresentation> createFromList(String baseUri, List<Mappe> mapper) {
		List<MappeRepresentation> representations = new ArrayList<MappeRepresentation>();
		for (Mappe mappe : mapper) {
			representations.add(new MappeRepresentation(baseUri, mappe));
		}
		return representations;
	}

}
