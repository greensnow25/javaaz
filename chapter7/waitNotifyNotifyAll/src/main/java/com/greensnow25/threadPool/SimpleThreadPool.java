package com.greensnow25.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Public class SimpleThreadPool.
 *
 * @author greensnow25.
 * @version 1.
 * @since 10.07.2017.
 */
public class SimpleThreadPool {

    /**
     * method create ThreadPool equal to the number of processors in the system.
     */
    public void makePool() {
        int count = Runtime.getRuntime().availableProcessors();

        ExecutorService service = Executors.newFixedThreadPool(count);
        for (int i = 0; i != 100; i++) {
            service.submit(new Work(i));
        }
        service.shutdown();
    }

    /**
     * main.
     *
     * @para args args.
     */
    public static void main(String[] args) {
        SimpleThreadPool stp = new SimpleThreadPool();
        stp.makePool();
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
