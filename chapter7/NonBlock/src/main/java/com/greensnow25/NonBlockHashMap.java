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

    private final Map<Integer, Task> map;

    private final Lock lock = new ReentrantLock(true);
    private AtomicInteger atomicInteger = new AtomicInteger(1);
    // private final ConcurrentHashMap<Integer, String> hashMap;


    public NonBlockHashMap() {
        //     hashMap = new ConcurrentHashMap<>();
        this.map = new HashMap<>();
    }

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
            int newVersion = local.getAndIncrement();
            if (local.compareAndSet(oldVersion, newVersion)) {
                map.computeIfPresent(key, new BiFunction<Integer, Task, Task>() {
                    @Override
                    public Task apply(Integer integer, Task task) {
                        task.getVersion()
                        return null;
                    }
                })
                break cas;
            }
        }
    }

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

    public void print() {
        for (Integer i : map.keySet()) {
            System.out.println(map.get(i));
        }
    }

    public Map<Integer, Task> getMap() {
        return map;
    }
}
