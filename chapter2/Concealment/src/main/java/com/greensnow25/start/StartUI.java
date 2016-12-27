package com.greensnow25.start;

import com.greensnow25.modules.*;

/**
 * Created by
 */
public class StartUI {
    public static void main (String[] args) {
        Tracker tracker = new Tracker();

        Task t2 = new Task("first task", "first de1");
        Task t3 = new Task("wqe", "ewq");
        tracker.add(t3);
       // tracker.add(t2);
        //tracker.update(t3);
        tracker.delete(t3);


        for (Item item : tracker.getAll()) {
            System.out.println(item.getName() + " " + item.getDiscription());
        }
    }
}
