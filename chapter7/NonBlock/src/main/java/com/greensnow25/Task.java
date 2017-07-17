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
    private final int id;
    private final String taskName;
    private AtomicInteger version;


    public Task(int id, String taskName, int version) {
        this.id = id;
        this.taskName = taskName;
        this.version = new AtomicInteger(version);
    }

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public AtomicInteger getVersion() {
        return version;
    }

    public void setVersion(AtomicInteger version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (version != task.version) return false;
        return taskName != null ? taskName.equals(task.taskName) : task.taskName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
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
