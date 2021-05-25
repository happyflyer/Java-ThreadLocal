package org.example.java_threadlocal;

import org.junit.Test;

public class BasicApiTest {
    @Test
    public void testX1() {
        System.out.println(BasicApi.x1.get());
    }

    @Test
    public void testX2() {
        System.out.println(BasicApi.x2.get());
        System.out.println(BasicApi.x2.get());
        BasicApi.x2.set(101L);
        System.out.println(BasicApi.x2.get());
    }

    @Test
    public void testX3() {
        System.out.println(BasicApi.x3.get());
    }

    @Test
    public void testThread() {
        new Thread(() -> System.out.println(BasicApi.x3.get())).start();
        System.out.println(BasicApi.x3.get());
    }

    @Test
    public void testSet() {
        new Thread(() -> System.out.println(BasicApi.x3.get())).start();
        BasicApi.x3.set(107L);
        System.out.println(BasicApi.x3.get());
    }

    @Test
    public void testRemove() {
        System.out.println(BasicApi.x3.get());
        BasicApi.x3.set(107L);
        System.out.println(BasicApi.x3.get());
        BasicApi.x3.remove();
        System.out.println(BasicApi.x3.get());
    }
}
