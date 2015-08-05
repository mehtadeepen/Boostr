package com.intuit.honeybadgers.boostr.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author ddubois
 */
@Path( "/" )
public class ServerMain {
    @GET
    @Produces( MediaType.TEXT_PLAIN )
    public String basic() {
        return "Hello World";
    }
}
