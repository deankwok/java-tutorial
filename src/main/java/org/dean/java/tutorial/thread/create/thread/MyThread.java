package org.dean.java.tutorial.thread.create.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyThread extends Thread {

    @SneakyThrows
    @Override
    public void run() {
        log.info("Start to my thread.");

        Thread.sleep(1000);

        log.info("The end bye.");
    }
}
