package com.github.asufana;

import java.lang.reflect.*;

import net.sf.cglib.proxy.*;

import org.objenesis.*;

public class ProxyFactory {
    
    private static final Objenesis objenesis = new ObjenesisStd();
    
    public static <T> T createProxy(final Class<T> targetClass,
                                    final Callback callback) {
        for (final Constructor<?> constructor : targetClass.getDeclaredConstructors()) {
            constructor.setAccessible(true);
        }
        final Class<?> proxyClass = newInstance(targetClass);
        return targetClass.cast(createProxyInstance(proxyClass, callback));
    }
    
    private static Class<?> newInstance(final Class<?> clazz) {
        final Enhancer e = new Enhancer();
        e.setUseFactory(true);
        e.setSuperclass(clazz);
        e.setCallbackTypes(new Class[] {MethodInterceptor.class});
        return e.createClass();
    }
    
    private static Object createProxyInstance(final Class<?> proxyClass,
                                              final Callback callback) {
        final Factory proxy = (Factory) objenesis.newInstance(proxyClass);
        proxy.setCallbacks(new Callback[] {callback, NoOp.INSTANCE});
        return proxy;
    }
}
