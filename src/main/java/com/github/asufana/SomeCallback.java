package com.github.asufana;

import java.lang.reflect.*;

import net.sf.cglib.proxy.*;

public class SomeCallback implements MethodInterceptor {
    
    public static SomeCallback getInstance = new SomeCallback();
    
    private SomeCallback() {}
    
    @Override
    public Object intercept(final Object object,
                            final Method method,
                            final Object[] args,
                            final MethodProxy proxy) throws Throwable {
        System.out.println("Intercept!");
        return proxy.invokeSuper(object, args);
    }
}
