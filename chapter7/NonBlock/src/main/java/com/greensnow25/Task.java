package com.greensnow25;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Public class Task.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.07.2017.
 */
public class Task {
    /**
     * Task id.
     */
    private final int id;
    /**
     * Task name.
     */
    private final String taskName;
    /**
     * Version control.
     */
    private volatile int version;

    /**
     * constructor.
     *
     * @param id       id.
     * @param taskName name.
     * @param version  version.
     */
    public Task(int id, String taskName, int version) {
        this.id = id;
        this.taskName = taskName;
        this.version = 0;
    }

    public Task(int id, String taskName) {
        this.id = id;
        this.taskName = taskName;
    }

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getVersion() {
        return version;
    }

    public void update() {
        version++;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", version=" + version +
                '}';
    }
}
