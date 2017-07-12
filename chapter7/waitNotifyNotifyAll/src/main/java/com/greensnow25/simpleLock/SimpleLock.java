package com.greensnow25.simpleLock;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Public class SimpleLock.
 *
 * @author greensnow25.
 * @version 1.
 * @since 11.07.2017.
 */
public class SimpleLock {
    /**
     * monitor.
     */
    private Object monitor;
    /**
     * state.
     */
    private boolean lock;

    /**
     * constructor.
     */
    public SimpleLock() {
        this.monitor = new Object();
        this.lock = false;
    }

    /**
     * main.
     *
     * @param args args.
     */
    public static void main(String[] args) {

        SimpleLock simpleLock = new SimpleLock();

        Thread q = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                simpleLock.unlock();

            }
        });
        q.start();

        simpleLock.lock();
    }

    /**
     * lock monitor.
     */
    public void lock() {
        synchronized (this.monitor) {
            while (!lock) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock = true;
            }
        }
    }

    /**
     * unlock monitor.
     */
    public void unlock() {
        synchronized (monitor) {
            lock = false;
            monitor.notify();
        }
    }
}
