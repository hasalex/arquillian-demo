package org.sewatech.examples.arquillian.ejb;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 *
 * @author alexis
 */
public class GreeterUnitTest {

    Greeter greeter = new Greeter();
    
    @Test
    public void testGreet() throws Exception {
        String who = "Soft-Shake";
        String expected = "Hello " + who;
        String actual = greeter.greet(who);
        
        assertEquals(expected, actual);
    }

    @Test
    public void testGreetLocated() throws Exception {
        Location location = mock(Location.class);
        String defaultLocation = "nowhere";
        when(location.from()).thenReturn(defaultLocation);
        greeter.location = location;
        
        
        String who = "Soft-Shake";
        String expected = "Hello " + who + " from " + defaultLocation;
        String actual = greeter.greetLocated(who);
        
        assertEquals(expected, actual);
    }
}
