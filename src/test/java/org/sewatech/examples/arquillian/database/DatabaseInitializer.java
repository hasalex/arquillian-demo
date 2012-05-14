package org.sewatech.examples.arquillian.database;

import javax.persistence.EntityManager;
import org.sewatech.examples.arquillian.domain.Message;

/**
 * @author Alexis Hassler
 */
public class DatabaseInitializer {
    private final EntityManager em;

    public DatabaseInitializer(EntityManager em) {
        this.em = em;
    }    
    
    public void clearDatabase() {
        em.createQuery("delete from Message").executeUpdate();
    }

    public void insertData() {
        em.persist(buildMessage("First hello"));
        em.persist(buildMessage("Second hellop"));        
    }

    private Message buildMessage(String messageText) {
        Message firstMessage = new Message();
        firstMessage.setText(messageText);
        return firstMessage;
    }

}
