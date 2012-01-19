/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sewatech.examples.arquillian.ejb;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author alexis
 */
public class GreeterTest {
    
    Greeter greeter;
    
    @Before
    public void setUp() {
        greeter = new Greeter();
    }
    
    @Test
    public void testGreet() throws Exception {
        String who = "World";
        String expected = "Hello " + who;
        String actual = greeter.greet(who);
        
        assertEquals(expected, actual);        
    }

    @Test
    public void testGreetLocated() throws Exception {
        Location location = mock(Location.class);
        final String where = "Nowhere";
        when(location.from()).thenReturn(where);
        greeter.location = location;
        
        String who = "World";
        String expected = "Hello " + who + " from " + where;
        String actual = greeter.greetLocated(who);
        
        assertEquals(expected, actual);        
    }
}
