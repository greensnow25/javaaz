package com.greensnow25.increment;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * public class SecondWay.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.06.2017.
 */
public class SecondWay {
    /**
     * counter.
     */
    private AtomicInteger count  = new AtomicInteger(0);
    /**
     * first thread.
     */
    private Thread two;
    /**
     * second thread.
     */
    private Thread one;

    /**
     * create new myThread.
     */
    private class MyThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i != 10_000_000; i++) {
                count.getAndIncrement();
            }
        }
    }

    /**
     * run threads.
     */
    public void runThreads() {
        this.one = new Thread(new MyThread());
        this.two = new Thread(new MyThread());

        one.start();
        two.start();
    }

    /**
     * main.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SecondWay visibility = new SecondWay();
        visibility.runThreads();
        while (visibility.one.isAlive() || visibility.two.isAlive()) ;

        System.out.println(visibility.count);
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }
}
