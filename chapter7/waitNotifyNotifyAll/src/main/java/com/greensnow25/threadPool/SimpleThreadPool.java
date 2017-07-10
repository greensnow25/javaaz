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


    public void makePool() {
        int count = Runtime.getRuntime().availableProcessors();

        ExecutorService service = Executors.newFixedThreadPool(count);
        for (int i = 0; i != 100; i++) {
            service.submit(new Work(i));
        }


        System.out.println(count);
    }

    public static void main(String[] args) {
        SimpleThreadPool stp = new SimpleThreadPool();
        stp.makePool();
    }

    /**
     * usefull
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
