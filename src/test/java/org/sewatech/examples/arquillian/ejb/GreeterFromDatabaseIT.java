package org.sewatech.examples.arquillian.ejb;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sewatech.examples.arquillian.database.DatabaseInitializer;
import org.sewatech.examples.arquillian.domain.BlaBla;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author alexis
 */
@RunWith(Arquillian.class)
public class GreeterFromDatabaseIT {

    @Deployment
    public static Archive<?> deploy(){
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                         .addClasses(GreeterFromDatabase.class, BlaBla.class)
                         .addClass(DatabaseInitializer.class)
                         .addAsResource("META-INF/persistence.xml")
                         .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB GreeterFromDatabase greeter;
    
    @Resource(mappedName="java:/jdbc/sample") DataSource ds;
    
    @Before
    public void init() throws Exception {
        DatabaseInitializer dbInit = new DatabaseInitializer(ds.getConnection());
        
        dbInit.clearData();
        dbInit.insertData();
    }
    
    @Test
    public void testGreet() throws Exception {
        Long id = 100L;
        BlaBla message = greeter.greet(id);
        assertNotNull("No message found in DB", message);
        assertEquals("ID is not the same", id, message.getId());
        assertNotNull("Message text is null", message.getText());
    }
}
