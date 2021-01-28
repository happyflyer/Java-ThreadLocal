package org.example.java_threadlocal;

import org.junit.Test;

public class MyThreadLocal2Test {
    static MyThreadLocal2<Long> myThreadLocal2 = new MyThreadLocal2<>() {
        @Override
        protected Long initialValue() {
            return Thread.currentThread().getId();
        }
    };

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(myThreadLocal2.get());
            }).start();
        }
    }
}
