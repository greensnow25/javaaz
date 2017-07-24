package com.greensnow25.threadPool;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * Public class SimpleThreadPool.
 *
 * @author greensnow25.
 * @version 1.
 * @since 10.07.2017.
 */
public class SimpleThreadPool {
    /**
     * Thread pool.
     */
    private final Thread[] pool;

    /**
     * Task queue for execution.
     */
    private final Queue<Runnable> queue;

    /**
     * Constructor.
     */
    public SimpleThreadPool(int capacity) {
        this.queue = new ArrayBlockingQueue(capacity);
        this.pool = new Thread[Runtime.getRuntime().availableProcessors()];
    }

    /**
     * Method create ThreadPool equal to the number of processors in the system.
     */
    public void makePool() {
        for (int i = 0; i != pool.length; i++) {
            Thread q = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    synchronized (queue) {
                        try {
                            Thread.sleep(10);
                            Runnable runnable = queue.poll();
                            if (runnable != null) {
                                runnable.run();
                            }
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            });
            pool[i] = q;
            q.start();
        }
    }

    /**
     * destroy pool.
     */
    public synchronized void destroyPool() {
        while (true) {
            if (queue.isEmpty()) {
                for (int i = 0; i != pool.length; i++) {
                    System.out.println(pool[i].getName());
                    pool[i].interrupt();
                }
                break;
            }
        }
        System.out.println("Pool destroy.");
    }

    /**
     * make a work.
     */
    private void makeAWork() {
        for (int i = 0; i != 100; i++) {
            queue.add(new Work(i));
        }
        System.out.println("All work is done.");
    }

    /**
     * main.
     *
     * @para args args.
     */
    public static void main(String[] args) {
        SimpleThreadPool stp = new SimpleThreadPool(100);
        stp.makePool();
        stp.makeAWork();
        stp.destroyPool();
    }

    /**
     * inner class useful work, do something.
     */
    private class Work implements Runnable {
        /**
         * count .
         */
        int count;

        /**
         * constructor.
         *
         * @param count count.
         */
        public Work(int count) {
            this.count = count;
        }

        /**
         * run.
         */
        @Override
        public void run() {
            System.out.println(count);
        }
    }
}
