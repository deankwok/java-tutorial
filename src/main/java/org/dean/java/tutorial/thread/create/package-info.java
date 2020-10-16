/**
 * 当前包下的类是为了展示，如果创建线程；
 * 创建线程有三种方式：
 * 1、继承 {@link java.lang.Thread} 类并重写 run 方法
 * 2、实现 {@link java.lang.Runnable} 接口的 run 方法
 * 3、实现 {@link java.util.concurrent.Callable} 接口的 call 方法，并结合 {@link java.util.concurrent.FutureTask}
 *
 * 以及如何结合 lambda 表达式实现
 */
package org.dean.java.tutorial.thread.create;