package org.dean.java.tutorial.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 通过接口 Queue 实现自定义指定长度的 Queue
 * @param <E>
 */
public class LimitQueue<E> {

    private int limit;

    private Queue<E> queue = new LinkedList<>();

    public LimitQueue(int limit) {
        this.limit = limit;
    }

    public void offer(E e){
        if(queue.size() >= limit){
            queue.poll();
        }
        queue.offer(e);
    }

    public int getLimit() {
        return limit;
    }

    public int size() {
        return queue.size();
    }

    public Queue<E> getQueue() {
        return queue;
    }
}
