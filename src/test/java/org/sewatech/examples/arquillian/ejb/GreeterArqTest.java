package org.sewatech.examples.arquillian.ejb;

import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

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
    
    @EJB(beanName="Greeter")
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
