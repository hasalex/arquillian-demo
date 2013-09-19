package org.sewatech.examples.arquillian.rs;

import org.jboss.arquillian.container.test.api.*;
import org.jboss.arquillian.junit.*;
import org.jboss.arquillian.test.api.*;
import org.jboss.resteasy.client.*;
import org.jboss.shrinkwrap.api.*;
import org.jboss.shrinkwrap.api.spec.*;
import org.junit.*;
import org.junit.runner.*;
import org.sewatech.examples.arquillian.ejb.*;

import javax.ws.rs.core.*;
import java.net.*;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class GreeterArqIT {
 
    @Deployment(testable=false)
    public static Archive deploy() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                         .addClass(Greeter.class)
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
