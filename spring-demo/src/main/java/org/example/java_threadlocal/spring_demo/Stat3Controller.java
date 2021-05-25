package org.example.java_threadlocal.spring_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lifei
 */
@RestController
public class Stat3Controller {
    static Integer c = 0;

    @RequestMapping("/stat3")
    public Integer stat() {
        return c;
    }

    synchronized void addOperation() throws InterruptedException {
        Thread.sleep(100L);
        c++;
    }

    @RequestMapping("/add3")
    public Integer add() throws InterruptedException {
        this.addOperation();
        return 1;
    }
}
