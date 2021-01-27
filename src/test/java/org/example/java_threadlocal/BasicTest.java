package org.example.java_threadlocal;

import org.junit.Test;

public class BasicTest {
    @Test
    public void test() {
        System.out.println(Basic.x1.get());
        System.out.println("==========");
        System.out.println(Basic.x2.get());
        System.out.println(Basic.x2.get());
        Basic.x2.set(101L);
        System.out.println(Basic.x2.get());
        System.out.println("==========");
        System.out.println(Basic.x3.get());
        new Thread(() -> System.out.println(Basic.x3.get())).start();
        Basic.x3.set(102L);
        System.out.println(Basic.x3.get());
        Basic.x3.remove();
        System.out.println(Basic.x3.get());
    }
}
