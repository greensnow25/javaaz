package com.greensnow25;

import com.sun.deploy.util.SyncAccess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;


/**
 * Public class NonBlock.
 *
 * @author greensnow25.
 * @version 1.
 * @since 14.07.2017.
 */
public class NonBlockHashMap {
    /**
     * map.
     */
    private final Map<Integer, Task> map;
    /**
     * lock.
     */
    private final Lock lock = new ReentrantLock(true);
    /**
     * counter.
     */
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    /**
     * constructor.
     */
    public NonBlockHashMap() {
        this.map = new HashMap<>();
    }

    /**
     * add task to the map.
     *
     * @param newTask new Task.
     */
    public void add(Task newTask) {
        Lock lock = this.lock;
        cas:
        while (true) {
            if (lock.tryLock()) {
                try {
                    map.put(atomicInteger.getAndIncrement(), newTask);
                    System.out.println(Thread.currentThread().getName());
                    break cas;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    /**
     * update the task.
     *
     * @param key        of task? which need to update.
     * @param updateTask new task.
     * @throws Exception ex.
     */
    public void update(Integer key, Task updateTask) throws Exception {
        if (!map.containsKey(key)) {
            throw new Exception("Sorry, key does not exist.");
        }
        AtomicInteger local = this.atomicInteger;
        Task task = map.get(key);
        cas:
        while (true) {
            local.set(task.getVersion().get());
            int oldVersion = local.get();
            if (local.compareAndSet(oldVersion, oldVersion + 1)) {
                map.computeIfPresent(key, new BiFunction<Integer, Task, Task>() {
                    @Override
                    public Task apply(Integer integer, Task task) {
                        map.put(integer, updateTask);
                        task.getVersion().getAndIncrement();
                        map.get(integer).setVersion(oldVersion + 1);
                        return map.get(integer);
                    }
                });
                break cas;
            }
        }
    }

    /**
     * remove the task by the key.
     *
     * @param key key.
     * @throws InterruptedException ex.
     */
    public void remove(int key) throws InterruptedException {
        label:
        while (true) {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    map.remove(key);
                } finally {
                    lock.unlock();
                    break label;
                }
            }
        }
    }

    /**
     * print all tasks.
     */
    public void print() {
        for (Integer i : map.keySet()) {
            System.out.println(map.get(i));
        }
    }

    /**
     * get map.
     * @return hashMap.
     */
    public Map<Integer, Task> getMap() {
        return map;
    }
}
