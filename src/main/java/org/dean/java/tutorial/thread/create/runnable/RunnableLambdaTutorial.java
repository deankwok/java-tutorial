package org.dean.java.tutorial.thread.create.runnable;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j
public class RunnableLambdaTutorial {

    public static void main(String[] args) {

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
}
