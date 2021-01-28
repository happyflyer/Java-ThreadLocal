package org.example.java_threadlocal.spring_demo;

import java.util.Objects;

/**
 * @author lifei
 */
public class Val<T> {
    T v;

    public void set(T v) {
        this.v = v;
    }

    public T get() {
        return v;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }
}
