package org.dean.java.tutorial.thread.create.runnable;

public class RunnableTutorial {

    public static void main(String[] args) {

        RunnableTask task = new RunnableTask();

        new Thread(task).start();
        new Thread(task).start();
    }
}
