package no.arkitektum.kommit.n5.representation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import no.arkitektum.kommit.n5.model.Arkiv;

@XmlRootElement(name = "arkiv", namespace = Representation.N5_NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
public class ArkivRepresentation extends Representation {
	
	public String systemID;
	
	public String tittel;
	
	public String beskrivelse;
	
	public ArkivRepresentation(String baseUri, Arkiv arkiv, Link... links) {
		super(baseUri);
		systemID = arkiv.systemID;
		tittel = arkiv.tittel;
		beskrivelse = arkiv.beskrivelse;
		addLink(Representation.SELF_REL_VALUE, pathToSelf(), "");
		addLink("arkivdeler", pathToSelf() + "/arkivdeler", "Vis arkivdeler");
	}

	public static List<ArkivRepresentation> createFromList(String baseUri, List<Arkiv> all) {
		List<ArkivRepresentation> representations = new ArrayList<ArkivRepresentation>();
		for (Arkiv arkiv : all) {
			representations.add(new ArkivRepresentation(baseUri, arkiv));
		}
		return representations;
	}

	@Override
	public String pathToSelf() {
		return "arkiv/" + systemID;
	}
	
	
}
