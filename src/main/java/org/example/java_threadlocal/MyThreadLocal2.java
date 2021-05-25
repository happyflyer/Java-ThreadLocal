package org.example.java_threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lifei
 */
public class MyThreadLocal2<T> {
    static AtomicInteger atomic = new AtomicInteger();

    Integer threadLocalHash = atomic.addAndGet(0x61788647);

    static Map<Thread, Map<Integer, Object>> threadLocalMap = new HashMap<>();

    synchronized public static Map<Integer, Object> getMap() {
        var thread = Thread.currentThread();
        if (!threadLocalMap.containsKey(thread)) {
            threadLocalMap.put(thread, new HashMap<>());
        }
        return threadLocalMap.get(thread);
    }

    protected T initialValue() {
        return null;
    }

    public T get() {
        var map = getMap();
        if (!map.containsKey(this.threadLocalHash)) {
            map.put(this.threadLocalHash, initialValue());
        }
        return (T) map.get(this.threadLocalHash);
    }

    public void set(T v) {
        var map = getMap();
        map.put(this.threadLocalHash, v);
    }
}
