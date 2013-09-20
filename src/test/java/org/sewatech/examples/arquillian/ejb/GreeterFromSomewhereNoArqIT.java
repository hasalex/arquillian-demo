package org.sewatech.examples.arquillian.ejb;

import org.junit.*;

import javax.naming.*;
import java.util.*;

import static org.junit.Assert.*;

/**
 *
 * @author alexis
 */
public class GreeterFromSomewhereNoArqIT {

    static GreeterFromSomewhere greeter;
    static Context context;

    //@BeforeClass
    public static void initEJB() throws NamingException {
       Properties properties = new Properties();
       properties.put(Context.INITIAL_CONTEXT_FACTORY, 
                      "org.apache.openejb.client.LocalInitialContextFactory");
       context = new InitialContext(properties);
       greeter = (GreeterFromSomewhere) context.lookup("GreeterFromSomewhereLocalBean");
    }

    @Test @Ignore("HS dans la plupart des profils")
    public void testGreetLocated() throws Exception {
        String who = "World";
        String expected = "Hello " + who + " from Mix-IT";
        String actual = greeter.greet(who);
        
        assertEquals(expected, actual);
    }
}
