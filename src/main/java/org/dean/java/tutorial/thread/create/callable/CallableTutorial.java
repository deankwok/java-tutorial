package org.dean.java.tutorial.thread.create.callable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;

@Slf4j
public class CallableTutorial {

    public static void main(String[] args) {

        // 构建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallableTask());

        // 启动线程
        new Thread(futureTask).start();

        try {
            // 等待任务结束，并返回结果
            String result = futureTask.get();
            log.info("========= result: {}", result);
        } catch (Exception ex) {
            log.error("CallableLambdaTutorial", ex);
        }
    }
}
