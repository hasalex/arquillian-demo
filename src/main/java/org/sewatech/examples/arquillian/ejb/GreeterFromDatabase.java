package org.sewatech.examples.arquillian.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sewatech.examples.arquillian.domain.BlaBla;

/** 
 * Small example of EJB 3.1, with DB access
 * 
 * @author Alexis Hassler
 */
@Stateless
public class GreeterFromDatabase {
    
    @PersistenceContext
    private EntityManager em;
    
    public BlaBla greet(Long id) {
        return em.find(BlaBla.class, id);
    }

    public void save(String text) {
        BlaBla message = new BlaBla();
        message.setText(text);
        em.persist(message);
    }
}
