package org.dean.java.tutorial.thread.objects;

import lombok.extern.slf4j.Slf4j;
import org.dean.java.tutorial.lambda.exception.LambdaException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class MapTutorial {

    public static void main(String[] args) {
        IntStream.range(0, 5).boxed().forEach(
                LambdaException.consumerWrapperVoid(MapTutorial::concurrentHashMap3));
    }

    /**
     * 在并发情况下，对 ConcurrentHashMap 同一 Key 处理，Boolean
     */
    public static void concurrentHashMap1() throws InterruptedException {

        Map<String, Boolean> map = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        final Object lock = new Object();

        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {

                synchronized (lock) {
                    if (!map.containsKey("key") || !map.get("key")) {
                        map.put("key", true);
                    } else {
                        map.put("key", false);
                    }
                }
            });
        }

        Thread.sleep(3000);
        log.info("------ key: {}, value: {} ------", "key", map.get("key"));
        executorService.shutdown();
    }

    /**
     * 在并发情况下，对 ConcurrentHashMap 同一 Key 处理，Integer
     */
    public static void concurrentHashMap2() throws InterruptedException {

        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("key", 1);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        final Object lock = new Object();

        for (int i = 0; i < 1000; i++) {
            executorService.execute( () -> {
                synchronized (lock) {
                    int key = map.get("key") + 1; //step 1
                    map.put("key", key);//step 2
                }
            });
        }

        Thread.sleep(3000);
        log.info("------ key: {}, value: {} ------", "key", map.get("key"));
        executorService.shutdown();
    }

    /**
     * 在并发情况下，对 ConcurrentHashMap 同一 Key 处理，Integer
     */
    public static void concurrentHashMap3() throws InterruptedException {

        Map<String, AtomicInteger> map = new ConcurrentHashMap<>();
        map.put("key", new AtomicInteger(1));
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 1000; i++) {
            executorService.execute( () -> {

                map.get("key").incrementAndGet();
            });
        }

        Thread.sleep(3000);
        log.info("------ key: {}, value: {} ------", "key", map.get("key"));
        executorService.shutdown();
    }
}
