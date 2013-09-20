package org.sewatech.examples.arquillian.ejb;

import org.junit.*;
import org.sewatech.examples.arquillian.domain.*;

import javax.persistence.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GreeterFromDatabaseTest {
    
    GreeterFromDatabase greeter;
    
    @Before
    public void setUp() {
        greeter = new GreeterFromDatabase();
    }

    @Test
    public void testGreet() throws Exception {
        EntityManager em = mock(EntityManager.class);
        BlaBla expected = new BlaBla();
        when(em.find(BlaBla.class, 0L)).thenReturn(expected);
        greeter.em = em;

        assertEquals(expected, greeter.greet(0L));
    }
    @Test
    public void testSave() throws Exception {
        EntityManager em = mock(EntityManager.class);
        em.persist(any());
        greeter.em = em;

        greeter.save("Message");
    }
}
