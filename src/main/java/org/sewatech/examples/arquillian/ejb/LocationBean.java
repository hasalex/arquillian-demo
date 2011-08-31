package org.sewatech.examples.arquillian.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;

/** 
 * Smallest example of EJB 3.1
 * 
 * @author Alexis Hassler
 */
@Local(Location.class)
@Stateless
public class LocationBean implements Location {
    
    private String placeName = "Geneva";
    
    @Override
    public String from() {
        return placeName;
    }
}
