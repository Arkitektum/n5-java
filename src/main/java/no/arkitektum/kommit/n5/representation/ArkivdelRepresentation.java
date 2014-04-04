package no.arkitektum.kommit.n5.representation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import no.arkitektum.kommit.n5.model.Arkivdel;

@XmlRootElement(name = "arkivdel", namespace = Representation.N5_NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
public class ArkivdelRepresentation extends Representation {
	public String systemID;
	public String tittel;
	
	public ArkivdelRepresentation(String baseUri, Arkivdel arkivdel) {
		super(baseUri);
		this.systemID = arkivdel.systemID;
		this.tittel = arkivdel.tittel;
		addLink(SELF_REL_VALUE, pathToSelf(),"");
		addLink("mapper", pathToSelf() + "/mapper", "Vis mapper");
		addLink("arkiv", new ArkivRepresentation(baseUri, arkivdel.arkiv).pathToSelf(), "Vis arkiv");
	}

	public static List<ArkivdelRepresentation> createFromList(String baseUri, List<Arkivdel> arkivdeler) {
		List<ArkivdelRepresentation> representations = new ArrayList<>();
		for (Arkivdel arkivdel : arkivdeler) {
			representations.add(new ArkivdelRepresentation(baseUri, arkivdel));
		}
		return representations;
	}

	@Override
	public String pathToSelf() {
		return "arkivdel/" + systemID;
	}
	
	
}
