package org.sewatech.examples.arquillian.ejb;

import javax.ejb.Stateless;

/** 
 * Smallest example of EJB 3.1
 * 
 * @author Alexis Hassler
 */
@Stateless
public class Location {
    
    private String placeName = "Geneva";
    
    public String from() {
        return placeName;
    }
}
