package org.example.java_threadlocal.spring_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lifei
 */
@RestController
public class Stat2Controller {
    static Integer c = 0;

    @RequestMapping("/stat2")
    public Integer stat() {
        return c;
    }

    @RequestMapping("/add2")
    public Integer add() throws InterruptedException {
        // 模拟程序执行过程，如连接数据库等耗时操作
        Thread.sleep(100L);
        c++;
        return 1;
    }
}
