package org.sewatech.examples.arquillian.cdi;

import org.jboss.arquillian.container.test.api.*;
import org.jboss.arquillian.junit.*;
import org.jboss.shrinkwrap.api.*;
import org.jboss.shrinkwrap.api.asset.*;
import org.jboss.shrinkwrap.api.spec.*;
import org.junit.*;
import org.junit.runner.*;

import javax.inject.*;

import static org.junit.Assert.*;

/**
 *
 * @author alexis
 */
@RunWith(Arquillian.class)
public class GreeterArqWebIT {

    @Deployment //@OverProtocol("Local")
    public static Archive<?> deploy() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(Greeter.class, Location.class)
                .addAsLibrary("guava.jar")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Inject
    Greeter greeter;

    @Test
    public void testGreet() throws Exception {
        String who = "World";
        String expected = "Hi " + who;
        String actual = greeter.greet(who);

        assertEquals(expected, actual);
    }

    @Test
    public void testGreetLocated() throws Exception {
        String who = "World";
        String expected = "Hi " + who + " from Lyon";
        String actual = greeter.greetLocated(who);

        assertEquals(expected, actual);
    }

}
