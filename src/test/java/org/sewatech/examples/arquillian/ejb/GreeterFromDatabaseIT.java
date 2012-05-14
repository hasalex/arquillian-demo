package org.sewatech.examples.arquillian.ejb;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.sewatech.examples.arquillian.database.DatabaseInitializer;
import org.sewatech.examples.arquillian.domain.Message;

/**
 * @author alexis
 */
@RunWith(Arquillian.class)
public class GreeterFromDatabaseIT {

    @Deployment
    public static Archive<?> deploy(){
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                         .addClasses(GreeterFromDatabase.class, Message.class)
                         .addClass(DatabaseInitializer.class)
                         .addAsResource("META-INF/persistence.xml")
                         .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    GreeterFromDatabase greeter;
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    UserTransaction tx;
    
    @Before
    public void initJPA() throws Exception {
        DatabaseInitializer dbInit = new DatabaseInitializer(em);
        
        tx.begin();
        em.joinTransaction();
        
        dbInit.clearDatabase();
        dbInit.insertData();
    }
    
    @After
    public void tearBownJPA() throws Exception {
        tx.rollback();
    }
    
    @Test
    public void testGreet() throws Exception {
        Long id = 1L;
        Message message = greeter.greet(id);
        assertNotNull("No message found in DB", message);
        assertEquals("ID is not the same", id, message.getId());
        assertNotNull("Message text is null", message.getText());
    }
}
