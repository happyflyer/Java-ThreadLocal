package org.example.java_threadlocal.spring_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lifei
 */
@RestController
public class Stat5Controller {
    /**
     * static Map<Thread, Integer> map = new HashMap<>();
     * 我们要同时将 Integer 存在 ThreadLocal 和 Map 里，应该是引用类型
     * static Map<Thread, Val<Integer>> map2 = new HashMap<>();
     * 只需要 Set 就可以了
     */
    static Set<Val<Integer>> set = new HashSet<>();

    synchronized static void addSet(Val<Integer> v) {
        set.add(v);
    }

    static ThreadLocal<Val<Integer>> c = ThreadLocal.withInitial(() -> {
        Val<Integer> v = new Val<>();
        v.set(0);
        addSet(v);
        return v;
    });

    void addOperation() throws InterruptedException {
        Thread.sleep(100L);
        Val<Integer> v = c.get();
        v.set(v.get() + 1);
    }

    @RequestMapping("/add5")
    public Integer add() throws InterruptedException {
        this.addOperation();
        return 1;
    }

    @RequestMapping("/stat5")
    public Integer stat() {
        return set.stream().map(Val::get).reduce(Integer::sum).orElse(0);
        // return set.stream().map(x -> x.get()).reduce((a, x) -> a + x).get();
    }
}
