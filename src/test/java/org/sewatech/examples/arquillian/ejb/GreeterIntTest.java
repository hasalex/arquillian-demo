package org.sewatech.examples.arquillian.ejb;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexis
 */
public class GreeterIntTest {

    static Greeter greeter;
    static Context context;

    @BeforeClass
    public static void initEJB() throws NamingException {
       Properties properties = new Properties();
       properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
       context = new InitialContext(properties);
       greeter = (Greeter) context.lookup("GreeterLocalBean");
    }

    @Test 
    public void testGreet() throws Exception {        
    }

    @Test
    public void testGreetLocated() throws Exception {
    }
}
