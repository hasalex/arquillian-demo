package org.sewatech.examples.arquillian.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;

/** 
 * Smallest example of EJB 3.1
 * 
 * @author Alexis Hassler
 */
@Local
@Stateless
public class GreeterBean {
    public String greet(String name) {
        return "Hello " + name;
    }
}
