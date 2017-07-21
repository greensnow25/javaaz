package com.greensnow25;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Public class CreatePool.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.07.2017.
 */
public class CreatePool {
    /**
     * class object.
     */
    private final ExecutorService ex;
    /**
     * Non-blocking object of HashMap;
     */
    private NonBlockCache nb;
    /**
     * count.
     */
    private int count = 0;
    /**
     * Task list.
     */
    private List<Runnable> list;

    /**
     * constructor.
     */
    public CreatePool() {
        ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        this.nb = new NonBlockCache();
    }

    /**
     * @throws Exception ex.
     */
    public void createPool() throws InterruptedException, Exception {
        this.list = this.createTasksList();
        for (Runnable r : list) {
            ex.execute(r);
        }
        ex.shutdown();
        ex.awaitTermination(1, TimeUnit.SECONDS);
        nb.print();

    }

    /**
     * method create task list.
     *
     * @return task list.
     */
    protected List<Runnable> createTasksList() {
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i != 100; i++) {
            tasks.add(new Runnable() {
                @Override
                public void run() {
                    nb.add(0, new Task(generateId(), "Tom", 1));
                    System.out.println(count);
                }
            });
        }
        return tasks;
    }

    /**
     * generate id.
     *
     * @return id.
     */
    private int generateId() {
        return count++;
    }

    /**
     * non- block hashMap.
     *
     * @return
     */
    public NonBlockCache getNb() {
        return nb;
    }

    /**
     * main.
     *
     * @param args args.
     * @throws Exception ex.
     */
    public static void main(String[] args) throws Exception {
        CreatePool createPool = new CreatePool();
        createPool.createPool();

/**
 * testing.
 */
        Thread.sleep(100);
        createPool.getNb().update(22, new Task(1, "wdsdwsdwdw"));
        System.out.println(createPool.getNb().getMap().get(22));
        Thread.sleep(1000);
        System.out.println(createPool.getNb().getMap().get(22).getTaskName());
        createPool.getNb().remove(22);
        System.out.println(createPool.getNb().getMap().get(22));
        System.out.println("main end");

    }
}
