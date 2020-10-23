package org.dean.java.tutorial.thread.create.runnable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

/**
 * 使用 lambda 表达式实现 @{link Runnable}
 */
@Slf4j
public class RunnableLambdaTutorial {

    public static void main(String[] args) {

        create1();
//        create2();
    }

    public static void create1() {
        Runnable runnable = () -> {

            log.info("Start to lambda runnable task.");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                log.error("RunnableLambdaTutorial", e);
            }

            log.info("The end bye.");
        };

        new Thread(runnable).start();
    }

    public static void create2() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        IntStream.range(0, 100).forEach((i) -> {
            executorService.execute(() -> {
                log.info("The index is {}", i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
