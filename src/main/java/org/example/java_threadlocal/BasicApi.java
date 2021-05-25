package org.example.java_threadlocal;

/**
 * @author lifei
 */
public class BasicApi {
    /**
     * ThreadLocal<T>
     */
    public static ThreadLocal<Long> x1 = new ThreadLocal<>();
    public static ThreadLocal<Long> x2 = ThreadLocal.withInitial(() -> {
        System.out.println("initialValue x2");
        return 100L;
    });
    public static ThreadLocal<Long> x3 = ThreadLocal.withInitial(() -> {
        System.out.println("initialValue x3");
        return Thread.currentThread().getId();
    });
}
