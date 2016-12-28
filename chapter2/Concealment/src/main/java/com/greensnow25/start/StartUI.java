package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;


/**
 * public class StartUI run TRACKER.
 * @author grensnow25.
 * @since 28.12.16.
 * @version 1.0.
 */
public class StartUI {
    /**
     * main.
     * @param args string array.
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();

        Task t2 = new Task("first task", "first de1");
        Task t3 = new Task("wqe", "ewq");
        tracker.add(t3);
        tracker.add(t2);
        tracker.update(t3);
        tracker.findByName("wqe");


        for (Item item : tracker.getAll()) {
            System.out.format(item.getName(), item.getDiscription());
        }
    }
}
