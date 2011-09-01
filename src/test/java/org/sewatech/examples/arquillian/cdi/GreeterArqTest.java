package org.sewatech.examples.arquillian.cdi;

import javax.inject.Inject;
import static org.junit.Assert.*;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author alexis
 */ 
@RunWith(Arquillian.class)
public class GreeterArqTest {
    
    @Deployment
    public static JavaArchive deploy() {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                                    .addClasses(Greeter.class, Location.class)
                                    .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        
        return archive;             
    }
    
    @Inject
    Greeter bean;
    
    @Test
    public void testGreet() throws Exception {
        String name = "Soft Shake";
        String expected = "Hello " + name;
        String result = bean.greet(name);
        
        assertEquals("Something wrong in the greeting", expected, result);
    }

    @Test @Ignore
    public void testGreetLocated() throws Exception {
        String name = "Soft Shake";
        String expected = "Hello " + name + " from Geneva";
        String result = bean.greetLocated(name);
        
        assertEquals("Something wrong in the located greeting", expected, result);   
    }
}
