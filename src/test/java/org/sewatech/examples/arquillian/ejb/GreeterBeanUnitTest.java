package org.sewatech.examples.arquillian.ejb;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author alexis
 */
public class GreeterBeanUnitTest {
    
    GreeterBean bean;
    
    @Before
    public void initialize() {
        bean = new GreeterBean();
        LocationBean locationBean = mock(LocationBean.class);
        when(locationBean.from()).thenReturn("Geneva");
        bean.location = locationBean;
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
