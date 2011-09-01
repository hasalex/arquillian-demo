package org.sewatech.examples.arquillian.ejb;

import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.*;

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
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "test.jar")
                                        .addClasses(Greeter.class, Location.class);

        return archive;
    }
//    @Deployment
//    public static EnterpriseArchive deploy() {
//        JavaArchive jArchive = ShrinkWrap.create(JavaArchive.class, "test.jar")
//                                    .addClasses(Greeter.class, Location.class);
//        EnterpriseArchive archive = ShrinkWrap.create(EnterpriseArchive.class, "test.ear")
//                                        .addAsModule(jArchive);
//
//        return archive;
//    }
//    @Deployment
//    public static WebArchive deploy() {
//        WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war")
//                                    .addClasses(Greeter.class, Location.class);
//        
//        return archive;             
//    }
    @EJB
    Greeter bean;

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
