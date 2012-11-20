package org.sewatech.examples.arquillian.ejb;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author alexis
 */
@RunWith(Arquillian.class)
public class GreeterArqIT {

    @Deployment
    public static Archive<?> deploy(){
        return ShrinkWrap.create(JavaArchive.class)
                         .addClass(Greeter.class);
    }
      
    @EJB
    Greeter greeter;
    
    @Test
    public void testGreet() throws Exception {        
        String who = "World";
        String expected = "Hello " + who;
        String actual = greeter.greet(who);
        
        assertEquals(expected, actual);
    }

}
