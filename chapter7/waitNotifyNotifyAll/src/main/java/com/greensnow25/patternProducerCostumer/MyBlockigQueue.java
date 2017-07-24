package com.greensnow25.patternProducerCostumer;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Public class UsefulWork.
 *
 * @author greensnow25.
 * @version 1.
 * @since 07.07.2017.
 */
public class MyBlockigQueue<E> {
    /**
     * Blocking queue.
     */
    private List<E> queue;
    /**
     * Queue capacity.
     */
    private static final int CAPACITY = 10;

    /**
     * constructor.
     */
    public MyBlockigQueue() {
        this.queue = new ArrayList(CAPACITY);
    }

    /**
     * put number to the queue.
     *
     * @param e number.
     * @throws InterruptedException ex.
     */
    public void put(E e) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == CAPACITY) {
                queue.wait();
            }
            queue.add(e);
            System.out.printf("%s  %d%s", "PUT number:", e, System.getProperty("line.separator"));
            queue.notify();
        }
    }

    /**
     * get number from the queue.
     *
     * @throws InterruptedException ex.
     */
    public void get() throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == 0) {
                queue.wait();
            }
            E e = queue.remove(0);
            System.out.printf("%s  %d%s", "GET number:", e, System.getProperty("line.separator"));
            queue.notify();
        }
    }

}
