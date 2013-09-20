package org.sewatech.examples.arquillian.cdi;

import javax.inject.Inject;

/** 
 * Small example of CDI 1.0 bean
 */
public class Greeter {
    
    @Inject
    Location location;
    
    public String greet(String name) {
        return "Hi " + name;
    }

    public String greetLocated(String name) {
        return "Hi " + name + " from " + location.from();
    }
}
