package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by
 */

public class TrackerTest {

    @Test
    public void whenAddItemthenAddItem() {
    Tracker tracker = new Tracker();
        Task task = new Task("1","2");
        Item item1 = tracker.add(task);
        assertThat(item1, is(task));

    }

    @Test
    public void whenRunthenFindItemById() {
        Tracker tracker = new Tracker();
        Task task = new Task("1","2");
        String id = task.getId();
        Item item = tracker.findById(id);
        assertThat(item, is(id));
    }

    @Test
    public void generateId()  {

    }

    @Test
    public void getAll()  {
        Tracker tracker = new Tracker();
        Task task = new Task("1","2");
        Item[] result = new Item[10];
        result[1] = task;
        int count =0;
        for (Item item : result) {
            if (item != null){
                count++;
            }
        }
        assertThat(count, is(1));

    }

    @Test
    public void update()  {
        Tracker trackar = new Tracker();
        Task task = new Task("1","2");
        trackar.update(task);
       // assertThat(trackar.update(task), is(task));
    }

    @Test
    public void delete()  {

    }

    @Test
    public void findByName()  {
        Tracker tracker = new Tracker();
        Task task = new Task("1","2");
        String name = task.getName();
        Item item = tracker.findByName(name);
        assertThat(item, is(name));
    }

}