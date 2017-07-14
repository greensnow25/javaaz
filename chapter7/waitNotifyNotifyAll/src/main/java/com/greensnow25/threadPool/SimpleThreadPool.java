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
     * Number of cores in the system.
     */
    private final int coreCount;
    /**
     * Task queue for execution.
     */
    private final ArrayBlockingQueue<Runnable> queue;
    /**
     * Thread position.
     */
    private int index = 0;

    /**
     * Constructor.
     */
    public SimpleThreadPool() {
        this.coreCount = Runtime.getRuntime().availableProcessors();
        this.queue = new ArrayBlockingQueue(10);
        this.pool = new Thread[coreCount];
    }

    /**
     * Method create ThreadPool equal to the number of processors in the system.
     */
    public void makePool() {
        for (int i = 0; i != coreCount; i++) {
            Thread q = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    synchronized (queue) {
                        try {
                            Thread.sleep(10);
                            Runnable runnable = queue.poll(1, TimeUnit.SECONDS);
                            if (runnable != null) {
                                runnable.run();
                            }
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            });
            pool[index++] = q;
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
    public void makeAWork() {
        for (int i = 0; i != 100; i++) {
            try {
                queue.put(new Work(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All work is done.");
    }

    /**
     * main.
     *
     * @para args args.
     */
    public static void main(String[] args) {
        SimpleThreadPool stp = new SimpleThreadPool();
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
