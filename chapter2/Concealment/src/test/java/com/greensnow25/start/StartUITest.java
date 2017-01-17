package com.greensnow25.start;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
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
    private String id = "123";

    /**
     * run before test.
     */
    @Before
    public void befoteTest() {
       this.out = new ByteArrayOutputStream();

    }

    /**
     * test add item.
     */
    @Test
    public void whenAddItemtThenFindByNameAndPrint() {
        System.setOut(new PrintStream(out));
        Input input = new StubInput(new String[]{action[1], nameOne, discOne, action[0]});
        new StartUI(input).choise();
        String result = out.toString();
        assertThat(result, is("Заявка first добавлена\r\n"));

    }

    /**
     * test find by id.
     */
    @Test
    public void whenFindByIdReturnItemIdAndPrint() {
        Input input = new StubInput(new String[]{action[2], id, action[0]});
        System.setOut(new PrintStream(out));
        new StartUI(input).choise();
        String result = out.toString();
        assertThat(result, is("Ваша заявка не найдена\r\n"));
    }

    /**
     * test show all items.
     */
    @Test
    public void whenAddItemThenShowItems() {
        Input input = new StubInput(new String[]{action[1], nameOne, discOne, action[3], action[0]});
        System.setOut(new PrintStream(out));
        new StartUI(input).choise();
        String result = out.toString();
        assertThat(result, is("Заявка first добавлена\r\n"
                             + "first  first\r\n"));
    }

    /**
     * test update item.
     */
    @Test
    public void whenAddItemThenFindAndUpdateThen() {
        Input input = new StubInput(new String[]{action[1], nameOne, discOne, action[1], nameTwo, diskTwo,
                                                action[4], nameOne, nameTwo, diskTwo, action[3], action[0]});
        System.setOut(new PrintStream(out));
        new StartUI(input).choise();
        String result = out.toString();
        assertThat(result, is("Заявка first добавлена\r\n"
                            + "Заявка two добавлена\r\n"
                            + "two  two\r\n"
                            + "two  two\r\n"));
    }

    /**
     * test delete item.
     */
    @Test
    public void whenDeleteItemThenShowAll() {
        Input input = new StubInput(new String[]{action[1], nameOne, discOne, action[1], nameTwo, diskTwo,
                                                 action[5], nameOne, action[3], action[0]});
        System.setOut(new PrintStream(out));
        new StartUI(input).choise();
        String result = out.toString();
        assertThat(result, is("Заявка first добавлена\r\n"
                            + "Заявка two добавлена\r\n"
                            + "Заявка first удалена.\r\n"
                            + "two  two\r\n"));
    }

    /**
     * text find item by name.
     */
    @Test
    public void whenFindByNameThenReturnItem() {
        Input input = new StubInput(new String[]{action[1], nameOne, discOne, action[6], nameOne, action[0]});
        System.setOut(new PrintStream(out));
        new StartUI(input).choise();
        String result = out.toString();
        assertThat(result, is("Заявка first добавлена\r\n"
                            + "Заявка найдена : first  first\r\n"));
    }

    /**
     * test.
     */
    @Test
    public void hellotest() {
    new StartUI(new ConsoleInput()).hello();
    }




}