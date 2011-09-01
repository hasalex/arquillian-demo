package org.sewatech.examples.arquillian.ejb;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author alexis
 */
public class GreeterIntTest {
    
    Greeter bean;
    
    @Before
    public void initialize() throws NamingException {
       System.out.println("*********************");
       Properties properties = new Properties();
       properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
       Context initialContext = new InitialContext(properties);
       bean = (Greeter) initialContext.lookup("GreeterLocalBean");
    }
    
    @Test
    public void testGreet() throws Exception {
        String name = "Soft Shake";
        String expected = "Hello " + name;
        String result = bean.greet(name);
        
        assertEquals("Something wrong in the greeting", expected, result);
    }

    @Test
    public void testGreetLocated() throws Exception {
        String name = "Soft Shake";
        String expected = "Hello " + name + " from Geneva";
        String result = bean.greetLocated(name);
        
        assertEquals("Something wrong in the located greeting", expected, result);
        
    }
}
