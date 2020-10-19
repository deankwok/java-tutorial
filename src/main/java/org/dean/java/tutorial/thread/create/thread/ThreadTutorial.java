package org.dean.java.tutorial.thread.create.thread;

public class ThreadTutorial {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.setDaemon(true);
        thread.start();
    }
}
