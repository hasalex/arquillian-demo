package org.sewatech.examples.arquillian.cdi;

import org.junit.*;
import static org.junit.Assert.*;

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
        String expected = "Hi " + who;
        String actual = greeter.greet(who);
        
        assertEquals(expected, actual);        
    }

}
