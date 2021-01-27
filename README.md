# [Java-ThreadLocal](https://www.imooc.com/learn/1217)

一致性问题

1. 发生在多个主体对同一份数据无法达成共识。
2. 包括：分布式一致性问题、并发问题等。
3. 特点：场景多、问题复杂、难以察觉---需要严密的思考甚至数学论证。

一致性问题解决办法

1. 排队（例如：锁、互斥量、管程、屏障等）
2. 投票（例如：Paxos，Raft 等）
3. 避免（例如：ThreadLocal 等 空间换时间的方式）

<!-- ![一致性问题的解决办法](images/solutions-to-consistency-problems.jpg) -->

工作要求

- P4~P5 初中级了解基本概念、原理（**在别人做好的基础上开发**）
- P6 高级应对不同场景、正确使用、结果可预期（**了解毎种数据结构的正确使用姿势，以及为什么要用**）
- P7 专家、高专深度掌握原理、本质、可改进、可定制（**为什么要有某种数据结构，以及这种数据结构为什么要有这样的内部实现？**）

<!-- ![课程介绍1](images/course-introduction1.jpg) -->

内容

- P4~P5 介绍基础 API
- P6 介绍若干个关键使用场景，分析每个场景使用 `ThreadLocal` 的作用和必要性
- P7 专家带你手写实现一个 `ThreadLocal` 并帮助分解其中每个细节设计背后的原理

<!-- ![课程介绍2](images/course-introduction2.jpg) -->

总结

- 问题多不是坏事，这让程序员更有价值——我们的生存空间。
- 做长远的学习计划，以终为始，将一致性问题一网打尽—我们的应对策略。
- 重视本质学习是成为专家的必经之路。

<!-- ![课程介绍3](images/course-introduction3.jpg) -->

## 1. 什么是 ThreadLocal

定义：提供**线程局部**变量；一个线程局部变量在多个线程中，分别有独立的值（副本）。

特点：简单（开箱即用）、快速（无额外开销）、安全（线程安全）

场景：多线程场景（资源持有、线程一致性、并发计算、线程安全等场景）

<!-- ![什么是ThreadLocal1](images/ThreadLocal1.jpg) -->

实现原理：Java 中用**哈希表**实现。

应用范围：几乎**所有**提供多线程特征的语言。

![什么是ThreadLocal2](images/ThreadLocal2.jpg)

![什么是ThreadLocal3](images/ThreadLocal3.jpg)

![什么是ThreadLocal4](images/ThreadLocal4.jpg)

> 开箱即用，代码写出来是为了阅读，偶尔用于执行。

## 2. ThreadLocal 基本 API
