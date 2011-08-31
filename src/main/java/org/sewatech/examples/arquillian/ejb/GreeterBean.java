package org.sewatech.examples.arquillian.ejb;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/** 
 * Smallest example of EJB 3.0
 * 
 * @author Alexis Hassler
 */
@Local(Greeter.class)
@Stateless()
public class GreeterBean implements Greeter {
    
    @EJB
    Location location;
    
    @Override
    public String greet(String name) {
        return "Hello " + name;
    }

    @Override
    public String greetLocated(String name) {
        return "Hello " + name + " from " + location.from();
    }
}
