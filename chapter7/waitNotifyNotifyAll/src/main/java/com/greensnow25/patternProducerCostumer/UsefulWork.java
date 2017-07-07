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
     * blocking queue.
     */
    private ArrayList<Integer> queue;

    /**
     * constructor.
     */
    public UsefulWork() {
        this.queue = new ArrayList(10);
    }

    public void put(int number) throws InterruptedException {
        synchronized (queue) {
            while (checkNotNull() == 10) {
                queue.wait();
            }
            queue.add(number);
            System.out.printf("%s  %d%s", "PUT number:", number, System.getProperty("line.separator"));
            queue.notify();
        }
    }

    public void get() throws InterruptedException {
        synchronized (queue) {
            while (checkNotNull() == 0) {
                queue.wait();
            }
            int i = queue.remove(0);
            System.out.printf("%s  %d%s", "GET number:", i, System.getProperty("line.separator"));
         //   System.arraycopy(queue, 1, queue, 0, checkNotNull());
            queue.notify();
        }
    }

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
