package org.sewatech.examples.arquillian.ejb;

import javax.naming.*;
import java.util.*;

import static org.junit.Assert.*;

public class GreeterNoArqIT {

    static Greeter greeter;
    static Context context;

    //@BeforeClass
    public static void initEJB() throws NamingException {
       Properties properties = new Properties();
       properties.put(Context.INITIAL_CONTEXT_FACTORY, 
                      "org.apache.openejb.client.LocalInitialContextFactory");
       context = new InitialContext(properties);
       greeter = (Greeter) context.lookup("GreeterLocalBean");
    }

    //@Test @Ignore("HS dans la plupart des profils")
    public void testGreet() throws Exception {        
        String who = "World";
        String expected = "Hello " + who;
        String actual = greeter.greet(who);
        
        assertEquals(expected, actual);
    }
}
