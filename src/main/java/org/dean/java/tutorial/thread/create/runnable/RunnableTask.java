package org.dean.java.tutorial.thread.create.runnable;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableTask implements Runnable {

    @SneakyThrows
    @Override
    public void run() {

        log.info("Start to runnable task.");
        Thread.sleep(1000);
        log.info("The end bye.");

    }
}
