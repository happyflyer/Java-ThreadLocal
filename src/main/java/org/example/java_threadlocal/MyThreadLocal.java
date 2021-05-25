package org.example.java_threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lifei
 */
public class MyThreadLocal<T> {
    static Map<Thread, Map<MyThreadLocal<?>, Object>> threadLocalMap = new HashMap<>();

    synchronized public static Map<MyThreadLocal<?>, Object> getMap() {
        var thread = Thread.currentThread();
        if (!threadLocalMap.containsKey(thread)) {
            threadLocalMap.put(thread, new HashMap<MyThreadLocal<?>, Object>());
        }
        return threadLocalMap.get(thread);
    }

    protected T initialValue() {
        return null;
    }

    public T get() {
        var map = getMap();
        if (!map.containsKey(this)) {
            map.put(this, initialValue());
        }
        return (T) map.get(this);
    }

    public void set(T v) {
        var map = getMap();
        map.put(this, v);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
