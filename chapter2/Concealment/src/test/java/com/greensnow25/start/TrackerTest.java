package com.greensnow25.start;

import com.greensnow25.board.Item;
import com.greensnow25.board.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
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
    private Task taskOne;

    /**
     * prepare for tests.
     */

    @Before
    public void beforeTest() {
        this.tracker = new Tracker();
        this.task = new Task("first task", "first desk");
        this.taskOne = new Task("second task", "second desk");
    }

    /**
     * method checks whether the item has been added.
     */
    @Test
    public void whenAddItemThenFindItemById() {
        Item item = tracker.add(task);
        String id = task.getId();
        Item result = tracker.findById(id);
        assertThat(item, is(result));

    }

    /**
     * method search item by id.
     */
    @Test
    public void whenAddItemThenFindItemByIdAndAssertThem() {
        tracker.add(task);
        String id = task.getId();
        Item item = tracker.findById(id);
        assertThat(item.getId(), is(id));
    }

    /**
     * generate Id.
     */
    @Test
    public void wehnAddGenerateIdThenAssertNotNull() {
        tracker.add(task);
        String id = task.getId();
        assertNotNull(id);
    }

    /**
     * method show all items.
     */
    @Test
    public void whenAddItemsThenSwowLengthOfArray() {
        tracker.add(task);
        tracker.add(taskOne);
        List<Item> items = tracker.getAll();
        int result = items.size();
        assertThat(result, is(2));

    }

    /**
     * method rewrite item.
     */
    @Test
    public void whenSetNameThenUpdateName() {
        tracker.add(task);
        String id = task.getId();
        taskOne.setId(id);
        tracker.update(taskOne);
        assertThat(tracker.findById(task.getId()).getName(), is("second task"));

    }

    /**
     * metod delete item.
     */
    @Test
    public void whenDeleteItemThenReturnNull() {
        tracker.add(task);
        String id = task.getId();
        tracker.delete(task);
        assertNull(tracker.findById(id));
    }

    /**
     * method find by name.
     */
    @Test
    public void whenFindByNameThenAssertName() {
        tracker.add(task);
        String name = task.getName();
        Item item = tracker.findByName(name);
        assertThat(item.getName(), is(name));
    }

}