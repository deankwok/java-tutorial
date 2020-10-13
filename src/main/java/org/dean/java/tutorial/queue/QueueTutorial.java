package org.dean.java.tutorial.queue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * 教程 - 自定义指定长度的 Queue
 */
public class QueueTutorial {

    public static void main(String[] args) {

        LimitQueue<Long> queue = new LimitQueue<>(5);

        LongStream.range(0, 10).boxed()
                .forEach(queue::offer);

        List<Long> list = queue.getQueue()
                .stream()
                .filter(item -> item < 5)
                .collect(Collectors.toList());

        assert list.size() == 0;
    }
}
