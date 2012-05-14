package org.sewatech.examples.arquillian.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sewatech.examples.arquillian.ejb.GreeterFromSomewhere;

/**
 * @author alexis
 */
@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {

    @EJB
    GreeterFromSomewhere greeter;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final PrintWriter writer = response.getWriter();
        writer.append(greeter.greet("the Web"));
    }
    
}
