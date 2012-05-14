package org.sewatech.examples.arquillian.ejb;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author alexis
 */
public class GreeterFromSomewhereNoArqIT {

    static GreeterFromSomewhere greeter;
    static Context context;

    @BeforeClass
    public static void initEJB() throws NamingException {
       Properties properties = new Properties();
       properties.put(Context.INITIAL_CONTEXT_FACTORY, 
                      "org.apache.openejb.client.LocalInitialContextFactory");
       context = new InitialContext(properties);
       greeter = (GreeterFromSomewhere) context.lookup("GreeterFromSomewhereLocalBean");
    }

    @Test
    public void testGreetLocated() throws Exception {
        String who = "World";
        String expected = "Hello " + who + " from Mix-IT";
        String actual = greeter.greet(who);
        
        assertEquals(expected, actual);
    }
}
