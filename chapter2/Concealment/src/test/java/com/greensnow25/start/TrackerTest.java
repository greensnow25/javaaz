package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * public Class TrackerTest
 * @author greensnow25.
 * @since 27.12.16.
 * @version 1.0.
 */

public class TrackerTest {
    /**
     * object of class Tracker.
     */
    private Tracker tracker ;
    /**
     * first item for test.
      */
    private Task task;

    /**
     * prepare for tests.
     */

    @Before
    public void beforeItem() {
            this.tracker = new Tracker();
         this.task = new Task("first task", "first desk");
      // this.taskone = new Task ("second task", "second desk");
    }

    /**
     * method checks whether the item has been added.
     */
    @Test
    public void whenAddItemthenAddItem() {

        Item item = tracker.add(task);
        String id = task.getId();
        String iq = item.getId();
        assertThat(iq, is(id));

    }

    /**
     * method search item by id.
     */
    @Test
    public void whenRunthenFindItemByIdthenReturnItem() {

        String id = task.getId();
        Item item = tracker.findById(id);
        assertThat(item, is(id));
    }

    @Test
    public void generateId()  {

    }

    /**
     * method show all items
     */
    @Test
    public void whenGetAllthenShowItems()  {

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

    /**
     * method rewrite item/
     */
    @Test
    public void whenUpdateRunthenRewriteItem()  {
        tracker.add(task);
        String id = task.getId();
            tracker.update(task);
        String idup = task.getId();
       assertThat(idup, is(id));
    }

    /**
     * metod delete item
     */
    @Test
    public void whenDeleteItemReturnNull()  {
        tracker.add(task);
        String id  = task.getId();
        tracker.delete(task);
        assertNull(tracker.findById(id));
    }

    /**
     * method find by name.
     */
    @Test
    public void whenFindByNameReturnName()  {
        tracker.add(task);
        String name = task.getName();
        Item item = tracker.findByName(name);
        assertThat(item.getName(), is(name));
    }

}