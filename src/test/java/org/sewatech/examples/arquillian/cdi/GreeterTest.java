package org.sewatech.examples.arquillian.cdi;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GreeterTest {
    
    Greeter greeter;
    
    @Before
    public void setUp() {
        greeter = new Greeter();
    }
    
    @Test
    public void testGreet() throws Exception {
        String who = "World";
        String expected = "Hi " + who;
        String actual = greeter.greet(who);
        
        assertEquals(expected, actual);        
    }

    @Test
    public void testGreetLocated() throws Exception {
        Location location = mock(Location.class);
        String where = "Nowhere";
        when(location.from()).thenReturn(where);
        greeter.location = location;

        String who = "World";
        String expected = "Hi " + who + " from Nowhere";
        String actual = greeter.greetLocated(who);

        assertEquals(expected, actual);
    }
}
