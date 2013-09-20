package org.sewatech.examples.arquillian.ejb;

import org.junit.*;
import static org.junit.Assert.*;

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

}
