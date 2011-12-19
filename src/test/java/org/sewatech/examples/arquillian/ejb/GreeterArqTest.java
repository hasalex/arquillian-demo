package org.sewatech.examples.arquillian.ejb;

import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

/**
 *
 * @author alexis
 */
@RunWith(Arquillian.class)
public class GreeterArqTest {

    @Deployment
    public static Archive deploy() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                         .addClasses(Greeter.class, Location.class);
    }
    
    @EJB
    Greeter greeter;

    @Test 
    public void testGreet() throws Exception {        
        String who = "Soft-Shake";
        String expected = "Hello " + who;
        String actual = greeter.greet(who);
        
        assertEquals(expected, actual);
    }

    @Test
    public void testGreetLocated() throws Exception {
        String who = "Soft-Shake";
        String expected = "Hello " + who + " from Geneva";
        String actual = greeter.greetLocated(who);
        
        assertEquals(expected, actual);
    }
}
