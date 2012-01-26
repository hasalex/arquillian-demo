package org.sewatech.example.arquillian.cdi;

import static org.junit.Assert.*;
import org.sewatech.examples.arquillian.cdi.*;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author alexis
 */
@RunWith(Arquillian.class)
public class GreeterArqIT {

    @Deployment
    public static Archive<?> deploy(){
        return ShrinkWrap.create(JavaArchive.class)
                         .addClasses(Greeter.class, Location.class)
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
