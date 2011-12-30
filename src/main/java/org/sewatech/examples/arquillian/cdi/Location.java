package org.sewatech.examples.arquillian.cdi;

/** 
 * @author Alexis Hassler
 */
public class Location {
    
    private String placeName = "Switzerland";
    
    public String from() {
        return placeName;
    }
}
