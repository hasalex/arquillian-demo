package org.sewatech.examples.arquillian.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.sewatech.examples.arquillian.cdi.Location;

/** 
 * Small example of EJB 3.1, with CDI injection
 * 
 * @author Alexis Hassler
 */
@Stateless
@Path("/greeterlocated")
public class GreeterFromSomewhere {
    
    @Inject
    Location location;
    
    @GET
    @Path("/{name}")
    public String greet(@PathParam("name") String name) {
        return "Hello " + name + " from " + location.from();
    }
}
