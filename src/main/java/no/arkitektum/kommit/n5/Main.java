package no.arkitektum.kommit.n5;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.TracingConfig;

public class Main {
    public static final String BASE_URI = "http://localhost:8080/n5/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("no.arkitektum.kommit.n5", "no.arkitektum.kommit.n5.representation");
        rc.register(JacksonFeature.class);
        rc.register(LoggingFilter.class);
        rc.property(ServerProperties.TRACING, TracingConfig.ON_DEMAND.name());

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }
 
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.shutdownNow();
    }
}

