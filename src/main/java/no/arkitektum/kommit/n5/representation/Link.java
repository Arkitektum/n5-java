package no.arkitektum.kommit.n5.representation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "link", namespace = Representation.N5_NAMESPACE)
public class Link {
	public String rel;
	public String uri;
	public String title;
	
	public Link(String rel, String uri, String title) {
		this.rel = rel;
		this.uri = uri;
		this.title = title;
	}
}
