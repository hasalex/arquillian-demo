package org.sewatech.examples.arquillian.ejb;

import javax.inject.*;
import javax.interceptor.*;
import java.security.*;

public class SecurityInterceptor {

    @Inject Principal principal;

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception
    {
        if (principal == null) {
            throw new SecurityException("Aaaaaaaargh, don't have a principal");
        } else {
            return ctx.proceed();
        }
    }
}
