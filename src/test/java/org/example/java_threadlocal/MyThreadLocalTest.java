package org.example.java_threadlocal;

import org.junit.Test;

public class MyThreadLocalTest {
    static MyThreadLocal<Long> myThreadLocal = new MyThreadLocal<>() {
        @Override
        protected Long initialValue() {
            return Thread.currentThread().getId();
        }
    };

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(myThreadLocal.get());
            }).start();
        }
    }
}
