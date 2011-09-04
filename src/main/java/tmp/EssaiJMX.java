/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tmp;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 *
 * @author alexis
 */
public class EssaiJMX {

    public static void main(String... args) throws MalformedURLException, IOException {
        //String host = "ec2-107-20-184-81.compute-1.amazonaws.com";
        String host = "localhost";
        int port = 1090;

        String urlString = System.getProperty("jmx.service.url",
                "service:jmx:rmi:///jndi/rmi://" + host + ":" + port + "/jmxrmi");
        JMXServiceURL serviceURL = new JMXServiceURL(urlString);
        JMXConnector jmxConnector = JMXConnectorFactory.connect(serviceURL, null);
        MBeanServerConnection connection = jmxConnector.getMBeanServerConnection();

        //Invoke on the JBoss AS MBean server
        int count = connection.getMBeanCount();
        System.out.println(count);
        System.out.println("Fini");
    }
}
