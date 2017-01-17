package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * class StartUITest test an aplications wint the static input.
 * @author greensnow25.
 * @since 17.01.17.
 * @version 2.
 */
public class StartUITest {
    /**
     * ByteArrayOutputString.
     */
    private ByteArrayOutputStream out;
    /**
     * first item name.
     */
    private String nameOne = "first";
    /**
     * first item discription.
     */
    private String discOne = "first";
    /**
     * array of action.
     */
    private String[] action = new String[]{"0", "1", "2", "3", "4", "5", "6"};
    /**
     * second name .
     */
    private String nameTwo = "two";
    /**
     * second dicription.
     */
    private String diskTwo = "two";
    /**
     * id for search.
     */
    private String id;
    /**
     * Tracker.
     */
    private Tracker tracker;
    /**
     * run before test.
     */
    @Before
    public void befoteTest() {
        this.out = new ByteArrayOutputStream();
        this.tracker = new Tracker();

    }

    /**
     * test add item.
     */
    @Test
    public void whenAddItemtThenFindByNameAndPrint() {
        Input input = new StubInput(new String[]{action[1], nameOne, discOne, action[0]});
        new StartUI(input, tracker).choise();
        String result = tracker.findByName(nameOne).getName();
        assertThat(result, is("first"));

    }

    /**
     * test find by id.
     */
    @Test
    public void whenFindByIdReturnItemIdAndPrint() {
        tracker.add(new Task(nameOne, discOne));
        id = tracker.findByName(nameOne).getId();
        System.setOut(new PrintStream(out));
        Input input = new StubInput(new String[]{action[2], id, action[0]});
        new StartUI(input, tracker).choise();
        String result = out.toString();

        assertThat(result, is("Bаша заявка:first\r\n"));
    }

    /**
     * test show all items.
     */
    @Test
    public void whenAddItemThenShowItems() {
        Input input = new StubInput(new String[]{action[1], nameOne, discOne, action[3], action[0]});
        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).choise();
        String result = out.toString();

        assertThat(result, is("Заявка first добавлена\r\n"
                             + "first  first\r\n"));
    }

    /**
     * test update item.
     */
    @Test
    public void whenAddItemThenFindAndUpdateThen() {
        Item item = tracker.add(new Task(nameOne, diskTwo));
                    tracker.add(new Task(nameTwo, diskTwo));
        id = tracker.findByName(nameOne).getId();
        Input input = new StubInput(new String[]{action[4], nameOne, nameTwo,
                                                 diskTwo, action[3], action[0]});
        new StartUI(input, tracker).choise();
        String result = tracker.findById(id).getId();

        assertEquals(result, id);
    }

    /**
     * test delete item.
     */
    @Test
    public void whenDeleteItemThenShowAll() {
        tracker.add(new Task(nameOne, diskTwo));
        Input input = new StubInput(new String[]{action[5], nameOne, action[3], action[0]});
        new StartUI(input, tracker).choise();

        assertNull(tracker.findByName(nameOne));
    }

    /**
     * text find item by name.
     */
    @Test
    public void whenFindByNameThenReturnItem() {
        tracker.add(new Task(nameTwo, diskTwo));
        Input input = new StubInput(new String[]{action[6], nameOne, action[0]});
        new StartUI(input, tracker).choise();
        String result = tracker.findByName(nameTwo).getName();

        assertThat(result, is("two"));
    }

}