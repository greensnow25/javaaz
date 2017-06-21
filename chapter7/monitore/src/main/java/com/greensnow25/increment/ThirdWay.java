package com.greensnow25.increment;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * public class ThirdWay.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.06.2017.
 */
public class ThirdWay {
    /**
     * counter.
     */
    private int count = 0;
    /**
     * first thread.
     */
    private Thread two;
    /**
     * second thread.
     */
    private Thread one;

    Lock lock = new ReentrantLock(true);

    /**
     * create new myThread.
     */
    private class MyThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i != 10_000_000; i++) {
               while (!inc());
            }
        }
    }

    /**
     * increment.
     */
    public boolean inc() {
        if (lock.tryLock()) {
            count++;
            lock.unlock();
            return true;
        }
        return false;
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
        ThirdWay visibility = new ThirdWay();
        visibility.runThreads();
        while (visibility.one.isAlive() || visibility.two.isAlive()) ;

        System.out.println(visibility.count);
        System.out.println((System.currentTimeMillis() - start) / 100);
    }
}
