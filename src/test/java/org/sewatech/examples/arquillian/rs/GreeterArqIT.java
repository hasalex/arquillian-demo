package org.sewatech.examples.arquillian.rs;

import java.net.URL;
import org.sewatech.examples.arquillian.ejb.*;
import javax.ws.rs.core.MediaType;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;

/**
 *
 * @author alexis
 */
@RunWith(Arquillian.class)
public class GreeterArqIT {

    @Deployment(testable=false)
    public static Archive deploy() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                         .addClasses(Greeter.class, Location.class)
                         .addClass(JaxRsActivator.class);
    }
    
    @ArquillianResource
    URL deploymentUrl;
    
    @Test @RunAsClient
    public void testGreet() throws Exception { 
        String who = "World";
        ClientRequest request = new ClientRequest(deploymentUrl.toString() + "rest/greeter/" + who);
        request.header("Accept", MediaType.TEXT_PLAIN);

        ClientResponse<String> responseObj = request.get(String.class);
        assertEquals("Status code is wrong", 200, responseObj.getStatus());
        assertEquals("Hello " + who, responseObj.getEntity());        
    }

}
