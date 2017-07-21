package com.greensnow25;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Public class PairOfThreads.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.07.2017.
 */
public class PairOfThreads {
    /**
     * class object, using for tasks list created.
     */
    private CreatePool pool;
    /**
     * hashMap own implementation.
     */
    private NonBlockCache nb = new NonBlockCache();
    /**
     * tasks list.
     */
    private List<Runnable> list;
    /**
     * lock.
     */
    private Lock lock = new ReentrantLock(true);

    /**
     * constructor.
     */
    public PairOfThreads() {
        this.pool = new CreatePool();
    }

    /**
     * method create two threads.
     *
     * @return Thread.
     */
    private Thread createThread() {
        return new Thread(() -> {
            while (true) {
                if (lock.tryLock()) {
                    try {
                        Runnable task = list.get(0);
                        task.run();
                        list.remove(task);
                    } finally {
                        lock.unlock();
                    }
                }
                if (list.size() == 0) {
                    break;
                }
            }
            System.out.printf("Thread %s die.%s", Thread.currentThread().getName(), System.getProperty("line.separator"));
        });
    }

    /**
     * create two threads.
     *
     * @throws InterruptedException ex.
     */
    public void makeTwoThreads() throws InterruptedException {
        this.list = pool.createTasksList();
        Thread one = createThread();
        Thread two = createThread();
        two.start();
        one.start();
        nb.print();
    }

    /**
     * main.
     *
     * @param args args.
     * @throws Exception ex.
     */
    public static void main(String[] args) throws Exception {
        PairOfThreads pairOfThreads = new PairOfThreads();
        pairOfThreads.makeTwoThreads();
        System.out.println("main end");

    }
}
