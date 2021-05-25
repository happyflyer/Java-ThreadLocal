package org.example.java_threadlocal.spring_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lifei
 */
@RestController
public class Stat4Controller {
    static ThreadLocal<Integer> c = ThreadLocal.withInitial(() -> 0);

    void addOperation() throws InterruptedException {
        Thread.sleep(100L);
        c.set(c.get() + 1);
    }

    @RequestMapping("/add4")
    public Integer add() throws InterruptedException {
        this.addOperation();
        return 1;
    }

    @RequestMapping("/stat4")
    public Integer stat() {
        return c.get();
    }
}
