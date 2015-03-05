package com.github.asufana;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class CglibTest {
    
    @Test
    public void test() throws Exception {
        final SomeEntity entity = ProxyFactory.createProxy(SomeEntity.class,
                                                           SomeCallback.getInstance);
        assertThat(entity.value(), is(nullValue()));
    }
    
}
