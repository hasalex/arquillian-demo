package org.sewatech.examples.arquillian.cdi;

import javax.inject.Inject;

/** 
 * Small example of CDI 1.0 bean
 * 
 * @author Alexis Hassler
 */
public class Greeter {
    
    @Inject
    Location location;
    
    public String greet(String name) {
        return "Hello " + name;
    }

    public String greetLocated(String name) {
        return "Hello " + name + " from " + location.from();
    }
}
