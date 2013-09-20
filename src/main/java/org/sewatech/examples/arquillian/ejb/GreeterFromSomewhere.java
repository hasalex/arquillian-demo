package org.sewatech.examples.arquillian.ejb;

import org.sewatech.examples.arquillian.cdi.*;

import javax.ejb.*;
import javax.inject.*;
import javax.interceptor.*;
import javax.ws.rs.*;

/** 
 * Small example of EJB 3.1, with CDI injection
 */
@Stateless
@Path("/greeterlocated")
@Interceptors({SecurityInterceptor.class})
public class GreeterFromSomewhere {
    
    @Inject
    Location location;
    
    @GET
    @Path("/{name}")
    public String greet(@PathParam("name") String name) {
        return "Hello " + name + " from " + location.from() + "\n";
    }
}
