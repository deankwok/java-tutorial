package org.dean.java.tutorial.thread.create.callable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

@Slf4j
public class CallableLambdaTutorial {

    public static void main(String[] args) {

        Callable<String> callable = () -> {

            log.info("Start to lambda runnable task.");
            sleep(1000);
            log.info("The end bye.");

            return "Hello Word";
        };

        // 构建异步任务
        FutureTask<String> futureTask = new FutureTask<>(callable);

        // 启动线程
        new Thread(futureTask).start();

        try {
            // 等待任务结束，并返回结果
            String result = futureTask.get();
            log.info("========= result: {}", result);

        } catch (Exception ex) {
            log.error("CallableLambdaTutorial");
        }
    }
}
