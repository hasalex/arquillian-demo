/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sewatech.examples.arquillian.ejb;

/**
 *
 * @author alexis
 */
public interface Greeter {

    String greet(String name);

    String greetLocated(String name);
    
}
