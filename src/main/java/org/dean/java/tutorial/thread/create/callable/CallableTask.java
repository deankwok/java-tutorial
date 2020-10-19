package org.dean.java.tutorial.thread.create.callable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

@Slf4j
public class CallableTask implements Callable<String> {

    @Override
    public String call() throws Exception {

        log.info("Start to runnable task.");
        sleep(1000);
        log.info("The end bye.");

        return "Hello Word";
    }
}
