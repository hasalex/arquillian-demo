package org.sewatech.examples.arquillian.cdi;

import javax.ejb.Stateless;

/** 
 * @author Alexis Hassler
 */
public class Location {
    
    private String placeName = "Geneva";
    
    public String from() {
        return placeName;
    }
}
