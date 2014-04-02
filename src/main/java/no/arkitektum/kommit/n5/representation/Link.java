package no.arkitektum.kommit.n5.representation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "link", namespace = Representation.N5_NAMESPACE)
public class Link {
	public String rel;
	public String uri;
	
	public Link(String rel, String uri) {
		this.rel = rel;
		this.uri = uri;
	}
}
