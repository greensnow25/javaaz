package com.greensnow25;

import com.sun.deploy.util.SyncAccess;
import jdk.nashorn.internal.ir.Optimistic;

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
public class NonBlockCache {
    /**
     * map.
     */
    private final Map<Integer, Task> map;

    /**
     * constructor.
     */
    public NonBlockCache() {
        this.map = new HashMap<>();
    }

    /**
     * add task to the map.
     *
     * @param newTask new Task.
     */
    public void add(Integer key, Task newTask) {
        map.putIfAbsent(key, newTask);
    }

    /**
     * update the task.
     *
     * @param key        of task? which need to update.
     * @param updateTask new task.
     */
    public void update(Integer key, Task updateTask) {
        map.computeIfPresent(key, new BiFunction<Integer, Task, Task>() {
            @Override
            public Task apply(Integer integer, Task task) {
                if (task.getVersion() == updateTask.getVersion()) {
                    task = updateTask;
                    task.update();
                    return task;
                } else {
                    throw new OptimisticException("Versions do not match!");
                }
            }
        });
    }

    /**
     * remove the task by the key.
     *
     * @param key key.
     * @throws InterruptedException ex.
     */
    public void remove(int key) {
        map.computeIfPresent(key, (integer, task) -> null);
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
     *
     * @return hashMap.
     */
    public Map<Integer, Task> getMap() {
        return map;
    }
}
