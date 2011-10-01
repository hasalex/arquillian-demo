package org.sewatech.examples.arquillian.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/** 
 * Small example of EJB 3.1
 * 
 * @author Alexis Hassler
 */
@Stateless
@Path("/greeter")
public class Greeter {
    
    @EJB
    Location location;
    
    @GET
    @Path("/{name}")
    public String greet(@PathParam("name") String name) {
        return "Hello " + name;
    }

    public String greetLocated(String name) {
        return "Hello " + name + " from " + location.from();
    }
}
