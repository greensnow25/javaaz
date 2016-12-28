package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * public Class TrackerTest.
 *
 * @author greensnow25.
 * @version 1.0.
 * @since 27.12.16.
 */

public class TrackerTest {
    /**
     * object of class Tracker.
     */
    private Tracker tracker;
    /**
     * first item for test.
     */
    private Task task;
    /**
     * second item for test.
     */
    private Task taskone;

    /**
     * prepare for tests.
     */

    @Before
    public void beforeItem() {
        this.tracker = new Tracker();
        this.task = new Task("first task", "first desk");
        this.taskone = new Task("second task", "second desk");
    }

    /**
     * method checks whether the item has been added.
     */
    @Test
    public void whenAddItemthenAddItem() {

        Item item = tracker.add(task);
        String id = task.getId();
        Item result = tracker.findById(id);
        assertThat(item, is(result));

    }

    /**
     * method search item by id.
     */
    @Test
    public void whenRunthenFindItemByIdthenReturnItem() {
        tracker.add(task);
        String id = task.getId();
        Item item = tracker.findById(id);
        assertThat(item.getId(), is(id));
    }

    /**
     * generate Id.
     */
    @Test
    public void wehnGenerateIdReturnNotNull() {
        tracker.add(task);
        String id = task.getId();
        assertNotNull(id);
    }

    /**
     * method show all items.
     */
    @Test
    public void whenGetAllthenShowItems() {
        tracker.add(task);
        tracker.add(taskone);
        tracker.getAll();
        int result = tracker.getPosition();
        assertThat(result, is(2));

    }

    /**
     * method rewrite item.
     */
    @Test
    public void whenUpdateRunthenRewriteItem() {
        tracker.add(task);
        String id = task.getId();
        tracker.update(task);
        Item item = tracker.findById(task.getId());
        assertThat(item.getId(), is(id));
        assertNotEquals(task, is(task));
    }



    /**
     * metod delete item.
     */
    @Test
    public void whenDeleteItemReturnNull() {
        tracker.add(task);
        String id = task.getId();
        tracker.delete(task);
        assertNull(tracker.findById(id));
    }

    /**
     * method find by name.
     */
    @Test
    public void whenFindByNameReturnName() {
        tracker.add(task);
        String name = task.getName();
        Item item = tracker.findByName(name);
        assertThat(item.getName(), is(name));
    }

}