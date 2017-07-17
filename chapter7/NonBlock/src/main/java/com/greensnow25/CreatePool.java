package com.greensnow25;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Public class CreatePool.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.07.2017.
 */
public class CreatePool {
    private final ExecutorService ex;
    NonBlockHashMap nb = new NonBlockHashMap();
    private int count = 0;
    List<Runnable> list;
    Lock lock = new ReentrantLock(true);

    public CreatePool() {

        ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void createPool() {
        this.list = this.createTasksList();
        for (Runnable r : list) {
            ex.execute(r);
        }
        ex.shutdown();
        try {
            ex.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ex.shutdownNow();
        nb.print();
    }

    public Thread createThread() {
        return new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    for (Iterator<Runnable> it = list.iterator(); it.hasNext(); ) {
                        if (lock.tryLock()) {
                            lock.lock();
                            try {
                                System.out.println(Thread.currentThread().getName());
                                it.next().run();
                                it.remove();
                            } finally {
                                lock.unlock();
                            }
                        }
                    }
                    if (list.size() == 0) {
                        break;
                    }
                }
                System.out.println("Thread die");
            }
        });
    }

    public void makeTwoThreads() throws InterruptedException {
        this.list = createTasksList();
        Thread one = createThread();
        Thread two = createThread();
        one.start();
        two.start();
        one.join();
        two.join();
        nb.print();
    }

    private List<Runnable> createTasksList() {
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i != 100; i++) {
            tasks.add(new Runnable() {
                @Override
                public void run() {
                    nb.add(new Task(generateId(), "Tom", 1));
                    System.out.println(count);
                }
            });
        }
        return tasks;
    }

    private int generateId() {
        return count++;
    }

    public static void main(String[] args) throws InterruptedException {
        CreatePool createPool = new CreatePool();
         createPool.createPool();
        //createPool.makeTwoThreads();

        System.out.println("main end");

    }
}
