package org.sewatech.examples.arquillian.ejb;

import org.sewatech.examples.arquillian.domain.*;

import javax.ejb.*;
import javax.persistence.*;

/** 
 * Small example of EJB 3.1, with DB access
 */
@Stateless
public class GreeterFromDatabase {
    
    @PersistenceContext
    EntityManager em;
    
    public BlaBla greet(Long id) {
        return em.find(BlaBla.class, id);
    }

    public void save(String text) {
        BlaBla message = new BlaBla();
        message.setText(text);
        em.persist(message);
    }
}
