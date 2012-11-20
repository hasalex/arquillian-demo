package org.sewatech.examples.arquillian.ejb;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sewatech.examples.arquillian.database.DatabaseInitializer;
import org.sewatech.examples.arquillian.domain.BlaBla;

import javax.ejb.EJB;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author alexis
 */
@RunWith(Arquillian.class)
@Cleanup(phase = TestExecutionPhase.BEFORE)
public class GreeterFromDatabaseApeIT {

    @Deployment
    public static Archive<?> deploy(){
        return ShrinkWrap.create(WebArchive.class, "test.war")
                         .addClasses(GreeterFromDatabase.class, BlaBla.class)
                         .addClass(DatabaseInitializer.class)
                         .addClass(GreeterFromDatabaseApeIT.class)
                         .addAsResource("META-INF/persistence.xml")
                         .addAsResource("log4j.xml")
                         .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB GreeterFromDatabase greeter;
    
    @Test @UsingDataSet("msg1.yml")
    public void testGreet() throws Exception {
        Long id = 100L;
        BlaBla message = greeter.greet(id);
        assertNotNull("No message found in DB", message);
        assertEquals("ID is not the same", id, message.getId());
        assertNotNull("Message text is null", message.getText());
    }

    @Test @ShouldMatchDataSet(value="expected-msg.yml", excludeColumns="id")
    public void testSave() throws Exception {
        greeter.save("Hi");
    }
}
