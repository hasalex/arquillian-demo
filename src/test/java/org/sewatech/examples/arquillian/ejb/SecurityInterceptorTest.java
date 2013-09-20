package org.sewatech.examples.arquillian.ejb;

import org.junit.*;
import sun.security.acl.*;

import javax.interceptor.*;

import static org.mockito.Mockito.*;

public class SecurityInterceptorTest {

    SecurityInterceptor securityInterceptor = new SecurityInterceptor();

    @Test
    public void testInterceptWithPrincipal() throws Exception {
        InvocationContext ctx = mock(InvocationContext.class);
        ctx.proceed();
        securityInterceptor.principal = new PrincipalImpl("TEST");

        securityInterceptor.intercept(ctx);

    }

    @Test(expected = SecurityException.class)
    public void testInterceptWithoutPrincipal() throws Exception {
        InvocationContext ctx = mock(InvocationContext.class);
        ctx.proceed();
        securityInterceptor.principal = null;

        securityInterceptor.intercept(ctx);

    }
}
