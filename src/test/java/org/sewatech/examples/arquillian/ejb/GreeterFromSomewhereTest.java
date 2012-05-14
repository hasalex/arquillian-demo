package org.sewatech.examples.arquillian.ejb;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.sewatech.examples.arquillian.cdi.Location;

/**
 *
 * @author alexis
 */
public class GreeterFromSomewhereTest {
    
    GreeterFromSomewhere greeter;
    
    @Before
    public void setUp() {
        greeter = new GreeterFromSomewhere();
    }
    
    @Test
    public void testGreetLocated() throws Exception {
        Location location = mock(Location.class);
        final String where = "Nowhere";
        when(location.from()).thenReturn(where);
        greeter.location = location;
        
        String who = "World";
        String expected = "Hello " + who + " from " + where;
        String actual = greeter.greet(who);
        
        assertEquals(expected, actual);        
    }
}
