package org.sewatech.examples.arquillian;

import org.junit.runner.*;
import org.junit.runners.*;
import org.sewatech.examples.arquillian.cdi.*;
import org.sewatech.examples.arquillian.ejb.*;
import org.sewatech.examples.arquillian.ejb.GreeterTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        GreeterFromSomewhereTest.class,
        GreeterTest.class,
        GreeterFromDatabaseTest.class,
        SecurityInterceptorTest.class,
        org.sewatech.examples.arquillian.cdi.GreeterTest.class,
        LocationTest.class})
public class TestSuite {
}
