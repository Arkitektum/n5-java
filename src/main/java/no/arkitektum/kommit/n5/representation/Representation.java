package no.arkitektum.kommit.n5.representation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public abstract class Representation {
	public static final String N5_MEDIA_TYPE = "application/vnd.kommitn5+json";
	public static final String N5_NAMESPACE = "http://dev.arkitektum.no/kommit/n5";

	public static final String RELATIONS_URI = "http://dev.arkitektum.no/kommit/n5/relations/";
	public static final String SELF_REL_VALUE = "self";

	@XmlElement(name = "link", namespace = N5_NAMESPACE)
	protected List<Link> links = new ArrayList<Link>();
	
	@XmlTransient
	protected String baseUri;
	
	public Representation(String baseUri) {
		this.baseUri = baseUri;
	}
	
	protected void addLink(String relation, String path, String title) {
		links.add(new Link(relation, baseUri + path,title));
	}
	
	public abstract String pathToSelf();
}