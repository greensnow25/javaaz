package com.greensnow25.patternProducerCostumer;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Public class UsefulWork.
 *
 * @author greensnow25.
 * @version 1.
 * @since 07.07.2017.
 */
public class UsefulWork {
    /**
     * Blocking queue.
     */
    private ArrayList<Integer> queue;
    /**
     * Queue capacity.
     */
    private static final int CAPACITY = 10;

    /**
     * constructor.
     */
    public UsefulWork() {
        this.queue = new ArrayList(CAPACITY);
    }

    /**
     * put number to the queue.
     *
     * @param number number.
     * @throws InterruptedException ex.
     */
    public void put(int number) throws InterruptedException {
        synchronized (queue) {
            while (checkNotNull() == CAPACITY) {
                queue.wait();
            }
            queue.add(number);
            System.out.printf("%s  %d%s", "PUT number:", number, System.getProperty("line.separator"));
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
            while (checkNotNull() == 0) {
                queue.wait();
            }
            int i = queue.remove(0);
            System.out.printf("%s  %d%s", "GET number:", i, System.getProperty("line.separator"));
            queue.notify();
        }
    }

    /**
     * Checks the values ​​on not null.
     *
     * @return the number of non null objects.
     */
    public int checkNotNull() {
        int count = 0;
        for (Integer i : queue) {
            if (i != null) {
                count++;
            } else break;
        }
        return count;
    }
}
