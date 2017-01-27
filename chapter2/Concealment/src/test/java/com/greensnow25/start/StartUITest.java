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
     * first comment.
     */
    private String commentOne = "first";
    /**
     * second comment.
     */
    private String commentTwo = "two";
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
        Input input = new StubInput(new String[]{action[0], nameOne, discOne, commentOne,
                                    "n", action[5], nameOne, "y"});
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
        Input input = new StubInput(new String[]{action[1], id, "y"});
        new StartUI(input, tracker).choise();
        String result = out.toString();
        String sep =  System.getProperty("line.separator");
        assertThat(result, is("0. Add the item." + sep
                            + "1. Find item by id." + sep
                            + "2. Show items ." + sep
                            + "3. Edit item." + sep
                            + "4. Delete item." + sep
                            + "5. Find item by name: " + sep
                            + "6. Add the comment" + sep
                            + "operation sucsesfull " + sep
                            + "name first desk first" + sep));
    }



    /**
     * test show all items.
     */
    @Test
    public void whenAddItemThenShowItems() {

        Input input = new StubInput(new String[]{action[0], nameOne, discOne, commentOne,
                                    "n", action[2], "y"});
        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).choise();
        String result = out.toString();
        Item item = tracker.findByName(nameOne);
        String id = item.getId();
        String name = item.getName();
        String desk = item.getDiscription();
        String sep = System.getProperty("line.separator");
        assertThat(result, is("0. Add the item." + sep
                             + "1. Find item by id." + sep
                             + "2. Show items ." + sep
                             + "3. Edit item." + sep
                             + "4. Delete item." + sep
                             + "5. Find item by name: " + sep
                             + "6. Add the comment" + sep
                             + "operation sucsesfull " + sep
                             + "0. Add the item." + sep
                             + "1. Find item by id." + sep
                             + "2. Show items ." + sep
                             + "3. Edit item." + sep
                             + "4. Delete item." + sep
                             + "5. Find item by name: " + sep
                             + "6. Add the comment" + sep
                             + "NAME  DESCRIPTION      ID    " + sep
                             + name + "  " +  desk + "  " + id + "  " + sep
                             + "COMMENTS LIST :" + sep
                             + "first  " + sep));
    }

    /**
     * test update item.
     */
    @Test
    public void whenAddItemThenFindAndUpdateThen() {
                    tracker.add(new Task(nameOne, diskTwo));
                    tracker.add(new Task(nameTwo, diskTwo));
        id = tracker.findByName(nameOne).getId();
        Input input = new StubInput(new String[]{action[3], nameOne, nameTwo,
                                                 diskTwo, "y"});
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
        Input input = new StubInput(new String[]{action[4], nameOne, "y"});
        new StartUI(input, tracker).choise();

        assertNull(tracker.findByName(nameOne));
    }

    /**
     * text find item by name.
     */
    @Test
    public void whenFindByNameThenReturnItem() {

        Item item = tracker.add(new Task(nameTwo, diskTwo));
        item.getComments().addComent(commentOne);
        Input input = new StubInput(new String[]{action[5], nameTwo, "y"});
        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).choise();
        String name = out.toString();
        String sep = System.getProperty("line.separator");

        assertThat(name, is("0. Add the item." + sep
                          + "1. Find item by id." + sep
                          + "2. Show items ." + sep
                          + "3. Edit item." + sep
                          + "4. Delete item." + sep
                          + "5. Find item by name: " + sep
                          + "6. Add the comment" + sep
                          + "operation sucsesfull " + sep
                          + " name  two desk  two " + sep));

    }

    /**
     * add comment from item.
     */
    @Test
    public void whenAddCommentThenShowComment() {
        Item item = tracker.add(new Task(nameOne, discOne));
        item.getComments().addComent(commentTwo);
        Input input = new StubInput(new String[]{action[6], nameOne, commentOne, "y"});
        new StartUI(input, tracker).choise();
        System.setOut(new PrintStream(out));
        for (String s : item.getComments().show()) {
            System.out.println(s);
        }
        String result = out.toString();
        String sep = System.getProperty("line.separator");

        assertThat(result, is("two" + sep + "first" + sep));

    }

}