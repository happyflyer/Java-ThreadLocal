package org.example.java_threadlocal.spring_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lifei
 */
@RestController
public class StatController {
    static Integer c = 0;

    @RequestMapping("/stat")
    public Integer stat() {
        return c;
    }

    @RequestMapping("/add")
    public Integer add() {
        c++;
        return 1;
    }
}
